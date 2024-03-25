// -Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
// методы. Реализовать в java.
// -Создать множество ноутбуков.
// -Написать метод, который будет запрашивать у пользователя критерий (или критерии)
// фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
// хранить в Map. Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// -Далее нужно запросить минимальные значения для указанных критериев - сохранить
// параметры фильтрации можно также в Map.
// -Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
// условиям.

import java.util.Map;
import java.util.Objects;

public class Laptop {
    private String brand; // бренд
    private String model; // модель
    private String processor; // Процессор
    private int ram; // ОЗУ
    private int hardDrive; // Жесткий диск
    private String operatingSystem; // Операционная система
    private String videoCard; // Видеокарта
    private double screenDiagonal; // Диагональ экрана
    private String color; // Цвет
    private double price; // Цена

    public Laptop(String brand, String model, String processor, int ram, int hardDrive, String operatingSystem,
            String videoCard, double screenDiagonal, String color, double price) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.operatingSystem = operatingSystem;
        this.videoCard = videoCard;
        this.screenDiagonal = screenDiagonal;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getProcessor() {
        return processor;
    }

    public int getRam() {
        return ram;
    }

    public int getHardDrive() {
        return hardDrive;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getVideoCard() {
        return videoCard;
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHardDrive(int hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setVideoCard(String videoCard) {
        this.videoCard = videoCard;
    }

    public void setScreenDiagonal(double screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    public void setcolor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean matches(Map<String, String> criteria) {
        for (Map.Entry<String, String> entry : criteria.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toLowerCase();

            try {
                switch (key) {
                    case "brand":
                        if (!this.getBrand().toLowerCase().contains(value))
                            return false;
                        break;
                    case "model":
                        if (!this.getModel().toLowerCase().contains(value))
                            return false;
                        break;
                    case "processor":
                        if (!this.getProcessor().toLowerCase().contains(value))
                            return false;
                        break;
                    case "ram":
                        if (this.getRam() < Integer.parseInt(value))
                            return false;
                        break;
                    case "hardDrive":
                        if (this.getHardDrive() < Integer.parseInt(value))
                            return false;
                        break;
                    case "operatingSystem":
                        if (!this.getOperatingSystem().toLowerCase().contains(value))
                            return false;
                        break;
                    case "videoCard":
                        if (!this.getVideoCard().toLowerCase().contains(value))
                            return false;
                        break;
                    case "screenDiagonal":
                        if (this.getScreenDiagonal() < Double.parseDouble(value))
                            return false;
                        break;
                    case "color":
                        if (!this.getColor().toLowerCase().contains(value))
                            return false;
                        break;
                    case "price":
                        if (this.getPrice() < Double.parseDouble(value))
                            return false;
                        break;
                    default:
                        System.out.println("Неизвестный критерий: " + key);
                        return false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка при преобразовании числового значения критерия: " + key);
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "ноутбук:\n" +
                "Бренд: " + brand +
                ", Модель: " + model +
                ", Процессор: " + processor +
                ", ОЗУ: " + ram + " ГБ" +
                ", Жесткий диск: " + hardDrive + " ГБ" +
                ", ОС: " + operatingSystem +
                ", Видеокарта: " + videoCard +
                ", Диагональ экрана: " + screenDiagonal + " дюйма" +
                ", Цвет: " + color +
                ", Цена: " + price + " руб." + "\n-----------------------";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Laptop laptop = (Laptop) o;
        return brand.equals(laptop.brand) &&
                model.equals(laptop.model) &&
                processor.equals(laptop.processor) &&
                ram == laptop.ram &&
                hardDrive == laptop.hardDrive &&
                operatingSystem.equals(laptop.operatingSystem) &&
                videoCard.equals(laptop.videoCard) &&
                Double.compare(screenDiagonal, laptop.screenDiagonal) == 0 &&
                color.equals(laptop.color) &&
                Double.compare(price, laptop.price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, processor, ram, hardDrive, operatingSystem, videoCard, screenDiagonal, color,
                price);
    }
}