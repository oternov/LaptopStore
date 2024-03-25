import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LaptopMain {
        public static void main(String[] args) {
                Laptop laptop1 = new Laptop("Lenovo", "IdeaPad 3", "Intel Core i5-1035G1", 8,
                                256, "Windows", "Integrated Intel UHD Graphics", 15.6, "Серый", 50000);
                Laptop laptop2 = new Laptop("HP", "Pavilion 15-eg0003ur", "Intel Core i7-1165G7", 16,
                                512, "Windows", "NVIDIA GeForce MX450", 15.6, "Красный", 80000);
                Laptop laptop3 = new Laptop("ASUS", "ZenBook 14 UX425EA", "Intel Core i5-1135G7", 8,
                                512, "Linux", "Integrated Intel Iris Xe Graphics", 14.0, "Белый", 60000);
                Laptop laptop4 = new Laptop("ASUS", "ZenBook 14 UX425EA", "Intel Core i5-1135G7", 8,
                                512, "Linux", "Integrated Intel Iris Xe Graphics", 14.0, "Белый", 60000);
                Laptop laptop5 = new Laptop("Dell", "XPS 13", "Intel Core i7-10710U", 16,
                                1024, "Windows", "Integrated Intel UHD Graphics", 13.3, "Черный", 120000);
                Laptop laptop6 = new Laptop("Apple", "MacBook Air", "Apple M1", 8,
                                256, "macOS", "Integrated 7-core GPU", 13.3, "Золотой", 95000);

                HashSet<Laptop> laptopSet = new HashSet<>(
                                Arrays.asList(laptop1, laptop2, laptop3, laptop4, laptop5, laptop6));
                for (Laptop laptop : laptopSet) {
                        System.out.println(laptop);
                }

                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите цифру, соответствующую необходимому критерию поиска: ");
                System.out.println("1 - Бренд");
                System.out.println("2 - Модель");
                System.out.println("3 - Процессор");
                System.out.println("4 - Оперативная память");
                System.out.println("5 - Объем жесткого диска");
                System.out.println("6 - Операционная система");
                System.out.println("7 - Видеокарта");
                System.out.println("8 - Диагональ экрана");
                System.out.println("9 - Цвет");
                System.out.println("10 - Цена");

                int number = scanner.nextInt();
                scanner.nextLine();

                String filterValue;
                switch (number) {
                        case 1:
                                System.out.println("Введите бренд:");
                                filterValue = scanner.nextLine();
                                filterLaptops(laptopSet, "brand", filterValue);
                                break;
                        case 2:
                                System.out.println("Введите модель:");
                                filterValue = scanner.nextLine();
                                filterLaptops(laptopSet, "model", filterValue);
                                break;
                        case 3:
                                System.out.println("Введите процессор:");
                                filterValue = scanner.nextLine();
                                filterLaptops(laptopSet, "processor", filterValue);
                                break;
                        case 4:
                                System.out.println("Введите оперативную память:");
                                filterValue = scanner.nextLine();
                                filterLaptops(laptopSet, "ram", filterValue);
                                break;
                        case 5:
                                System.out.println("Введите объем жесткого диска:");
                                filterValue = scanner.nextLine();
                                filterLaptops(laptopSet, "hardDrive", filterValue);
                                break;
                        case 6:
                                System.out.println("Введите операционную систему:");
                                filterValue = scanner.nextLine();
                                filterLaptops(laptopSet, "operatingSystem", filterValue);
                                break;
                        case 7:
                                System.out.println("Введите видеокарту:");
                                filterValue = scanner.nextLine();
                                filterLaptops(laptopSet, "videoCard", filterValue);
                                break;
                        case 8:
                                System.out.println("Введите диагональ экрана:");
                                filterValue = scanner.nextLine();
                                filterLaptops(laptopSet, "screenDiagonal", filterValue);
                                break;
                        case 9:
                                System.out.println("Введите цвет:");
                                filterValue = scanner.nextLine();
                                filterLaptops(laptopSet, "color", filterValue);
                                break;
                        case 10:
                                System.out.println("Введите цену:");
                                filterValue = scanner.nextLine();
                                filterLaptops(laptopSet, "price", filterValue);
                                break;
                        default:
                                System.out.println("Неверный критерий.");
                                break;
                }

                scanner.close();
        }

        private static void filterLaptops(Set<Laptop> laptops, String criteria, String value) {
                for (Laptop laptop : laptops) {
                        if (laptop.matches(criteria, value)) {
                                System.out.println("Найден " + laptop);
                        }
                }
        }

}
