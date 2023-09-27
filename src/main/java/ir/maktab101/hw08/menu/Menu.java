package ir.maktab101.hw08.menu;

import ir.maktab101.hw08.domain.Brand;
import ir.maktab101.hw08.domain.Category;
import ir.maktab101.hw08.domain.Product;
import ir.maktab101.hw08.domain.User;
import ir.maktab101.hw08.service.BrandService;
import ir.maktab101.hw08.service.CategoryService;
import ir.maktab101.hw08.service.ProductService;
import ir.maktab101.hw08.service.UserService;
import ir.maktab101.hw08.util.ApplicationContext;
import ir.maktab101.hw08.util.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    private final Scanner input = new Scanner(System.in);
    private final UserService userService = ApplicationContext.getInstance().getUserService();
    private final CategoryService categoryService = ApplicationContext.getInstance().getCategoryService();
    private final BrandService brandService = ApplicationContext.getInstance().getBrandService();
    private final ProductService productService = ApplicationContext.getInstance().getProductService();

    public Menu() {
    }

    public void mainMenu() throws SQLException {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("=======================");
            System.out.println("1- Sign in");
            System.out.println("2- Sign up");
            System.out.println("3- Exit");
            System.out.println("Choose an option:");
            int select = input.nextInt();
            input.nextLine();
            switch (select) {
                case 1 -> signIn();
                case 2 -> signUp();
                case 3 -> System.exit(-1);
                default -> System.out.println("invalid input");
            }
        }
    }

    public void signUp() throws SQLException {
        System.out.println("Enter your full name :");
        String fullName = input.nextLine();

        System.out.println("Enter your email:");
        String email = null;
        boolean emailflag = true;
        while (emailflag) {
            email = input.nextLine();
            if (Validation.isValidEmailWithRegex(email))
                emailflag = false;
            else
                System.out.println("please enter a valid email");
        }

        System.out.println("Enter your username:");
        String username = input.nextLine();

        System.out.println("Enter your password:");
        String password = null;
        boolean flag = true;
        while (flag) {
            password = input.nextLine();
            if (Validation.isValidPasswordWithRegex(password))
                flag = false;
            else
                System.out.println("please enter a valid password");
        }

        User user = new User(fullName, username, password, email);
        userService.save(user);
        System.out.println("you successfully added !");
        mainMenu();
    }

    public void signIn() throws SQLException {
        System.out.println("Enter your username:");
        String username = input.nextLine();
        System.out.println("Enter your password:");
        String password = input.nextLine();
        if (userService.login(username, password)) {
            System.out.println("you successfully logged in ");
            operationMenu();
        } else {
            System.out.println("wrong username or password");
            mainMenu();
        }
    }

    public void operationMenu() throws SQLException {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("=======================");
            System.out.println("1-Add a category");
            System.out.println("2-Add a brand");
            System.out.println("3-Add a product");
            System.out.println("4-Sign out");
            int number = input.nextInt();
            input.nextLine();
            switch (number) {
                case 1 -> addCategory();
                case 2 -> addBrand();
                case 3 -> addProduct();
                case 4 -> isTrue = false;
                default -> System.out.println("invalid input");
            }
        }
        mainMenu();
    }

    public void addCategory() throws SQLException {
        Category category = new Category();
        System.out.println("name: ");
        String categoryName = input.nextLine();
        System.out.println("description: ");
        String categoryDescription = input.nextLine();
        if (categoryService.existByName(categoryName)) {
            System.out.println("this category already exist ");
            operationMenu();
        } else {
            category.setName(categoryName);
            category.setDescription(categoryDescription);
            categoryService.save(category);
            System.out.println("category added to db");
        }
    }

    public void addBrand() throws SQLException {
        Brand brand = new Brand();
        System.out.println("name: ");
        String brandName = input.nextLine();
        System.out.println("description: ");
        String brandDescription = input.nextLine();
        System.out.println("website: ");
        String brandWebsite = null;
        boolean flag = true;
        while (flag) {
            brandWebsite = input.nextLine();
            if (Validation.isValidWebsiteWithRegex(brandWebsite))
                flag = false;
            else
                System.out.println("please enter a valid website address");
        }
        if (brandService.existByName(brandName)) {
            System.out.println("this brand already exist");
            operationMenu();
        } else {
            brand.setName(brandName);
            brand.setDescription(brandDescription);
            brand.setWebsite(brandWebsite);
            brandService.save(brand);
            System.out.println("brand added to db");
        }
    }

    public void addProduct() throws SQLException {
        //set a category for product
        long categoryNumber = selectCategory();
        //set a brand for product
        long brandNumber = selectBrand();
        if (categoryNumber == -1 || brandNumber == -1) {
            System.out.println("invalid category or brand number");
            operationMenu();
        } else {
            Category productCategory = (Category) categoryService.findById(categoryNumber);
            Brand productBrand = (Brand) brandService.findById(brandNumber);
            System.out.println("product name: ");
            String productName = input.next();
            //create a product
            Product product = new Product();
            product.setName(productName);
            product.setCategory(productCategory);
            product.setBrand(productBrand);
            //add product to db
            productService.save(product);
            //back to operation menu
            operationMenu();

        }
    }

    public int selectCategory() throws SQLException {
        System.out.println("select a category number: ");
        Category[] categories = categoryService.getCategory();
        for (Category category : categories) {
            System.out.println(category.getId() + " >> " + category.getName());
        }
        int number = input.nextInt();
        input.nextLine();
        //check if its valid
        boolean validCategoryNumber = false;
        for (Category category : categories) {
            if (category.getId() == number) {
                validCategoryNumber = true;
                break;
            }
        }
        if (validCategoryNumber) {
            return number;
        } else {
            return -1;
        }

    }

    public int selectBrand() throws SQLException {
        System.out.println("select a brand number: ");
        Brand[] brands = brandService.getBrands();
        for (Brand brand : brands) {
            System.out.println(brand.getId() + " >> " + brand.getName());
        }
        int number = input.nextInt();
        input.nextLine();
        //check if its valid
        boolean validBrandNumber = false;
        for (Brand brand : brands) {
            if (brand.getId() == number) {
                validBrandNumber = true;
                break;
            }
        }
        if (validBrandNumber) {
            return number;
        } else {
            return -1;
        }
    }
}
