import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LaptopMain {
        public static void main(String[] args) {
                Laptop laptop1 = new Laptop("Lenovo", "IdeaPad 3", "Intel Core i5-1035G1", 8,
                                256, "Windows", "Integrated Intel UHD Graphics", 15.6, "Gray", 50000);
                Laptop laptop2 = new Laptop("HP", "Pavilion 15-eg0003ur", "Intel Core i7-1165G7", 16,
                                512, "Windows", "NVIDIA GeForce MX450", 15.6, "Red", 80000);
                Laptop laptop3 = new Laptop("ASUS", "ZenBook 14 UX425EA", "Intel Core i5-1135G7", 8,
                                512, "Linux", "Integrated Intel Iris Xe Graphics", 14.0,
                                "White", 60000);
                Laptop laptop4 = new Laptop("ASUS", "ZenBook 14 UX425EA", "Intel Core i5-1135G7", 8,
                                512, "Linux", "Integrated Intel Iris Xe Graphics", 14.0, "White", 60000);
                Laptop laptop5 = new Laptop("Dell", "XPS 13", "Intel Core i7-10710U", 16,
                                1024, "Windows", "Integrated Intel UHD Graphics", 13.3, "Black", 120000);
                Laptop laptop6 = new Laptop("Apple", "MacBook Air", "Apple M1", 8,
                                256, "macOS", "Integrated 7-core GPU", 13.3, "Golden", 95000);

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
                Map<String, String> criteriaMap = new HashMap<>();
                String criteriaKey = "";

                switch (number) {
                        case 1:
                                System.out.println("Введите бренд:");
                                criteriaKey = "brand";
                                break;
                        case 2:
                                System.out.println("Введите модель:");
                                criteriaKey = "model";
                                break;
                        case 3:
                                System.out.println("Введите процессор:");
                                criteriaKey = "processor";
                                break;
                        case 4:
                                System.out.println("Введите оперативную память:");
                                criteriaKey = "ram";
                                break;
                        case 5:
                                System.out.println("Введите объем жесткого диска:");
                                criteriaKey = "hardDrive";
                                break;
                        case 6:
                                System.out.println("Введите операционную систему:");
                                criteriaKey = "operatingSystem";
                                break;
                        case 7:
                                System.out.println("Введите видеокарту:");
                                criteriaKey = "videoCard";
                                break;
                        case 8:
                                System.out.println("Введите диагональ экрана:");
                                criteriaKey = "screenDiagonal";
                                break;
                        case 9:
                                System.out.println("Введите цвет:");
                                criteriaKey = "color";
                                break;
                        case 10:
                                System.out.println("Введите цену:");
                                criteriaKey = "price";
                                break;
                        default:
                                System.out.println("Неверный критерий.");
                                scanner.close();
                                return;
                }

                filterValue = scanner.nextLine();
                criteriaMap.put(criteriaKey, filterValue);
                filterLaptops(laptopSet, criteriaMap);

                scanner.close();
        }

        private static void filterLaptops(Set<Laptop> laptops, Map<String, String> criteria) {
                for (Laptop laptop : laptops) {
                        if (laptop.matches(criteria)) {
                                System.out.println("Найден " + laptop);
                        }
                }
        }

}
