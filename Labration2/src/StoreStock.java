import products.Headphones;
import products.Soundbar;
import products.Speaker;
import products.TV;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

public class StoreStock {

    public static ArrayList<TV> tvStock = new ArrayList<>();
    public static ArrayList<Headphones> headphoneStock = new ArrayList<>();
    public static ArrayList<Speaker> speakerStock = new ArrayList<>();
    public static ArrayList<Soundbar> soundbarStock = new ArrayList<>();
    private String line;
    final String path = System.getProperty("user.home")
            + File.separator + "Documents"
            + File.separator + "StoreStock";

    final File storeStock = new File(path);
    final File TVStock = new File(storeStock + File.separator + "TVStock.csv");
    final File HeadphoneStock = new File(storeStock + File.separator + "HeadphoneStock.csv");
    final File SoundbarStock = new File(storeStock + File.separator + "SoundbarStock.csv");
    final File SpeakerStock = new File(storeStock + File.separator + "SpeakerStock.csv");

    public static Exporter exporter = new Exporter();

    public void executeStock() {
        if (storeStock.exists()) {
            System.out.println("Files loaded from stock folder");
        }else if (storeStock.mkdir())
        {
            System.out.println("Folder for stock was created at: " + storeStock);
        }

        if (TVStock.exists())
            try ( Scanner sc = new Scanner(TVStock) ) {
                while (sc.hasNext()) {
                    line = sc.nextLine();
                    String[] fields = line.split(",");
                    TV tvFromFile = new TV(fields[0], fields[1], Integer.parseInt(fields[2]),fields[3],Integer.parseInt(fields[4]),Boolean.parseBoolean(fields[5]));
                    tvStock.add(tvFromFile);
            }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        else {
            try {
                FileWriter out = new FileWriter(TVStock);
                out.close();
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        }

        if (HeadphoneStock.exists())
            try (Scanner sc = new Scanner(HeadphoneStock)) {
                while (sc.hasNext()) {
                    line = sc.nextLine();
                    String[] fields = line.split(",");
                    Headphones headphoneFromFile = new Headphones(fields[0], fields[1], Boolean.parseBoolean(fields[2]));
                    headphoneStock.add(headphoneFromFile);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        else {
            try {
                FileWriter out = new FileWriter(HeadphoneStock);
                out.close();
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        }

        if (SoundbarStock.exists())
            try (Scanner sc = new Scanner(SoundbarStock)) {
                while (sc.hasNext()) {
                    line = sc.nextLine();
                    String[] fields = line.split(",");
                    Soundbar soundbarFromFile = new Soundbar(fields[0], fields[1], Double.parseDouble(fields[2]));
                    soundbarStock.add(soundbarFromFile);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        else {
            try {
                FileWriter out = new FileWriter(SoundbarStock);
                out.close();
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        }

        if (SpeakerStock.exists())
            try(Scanner sc = new Scanner(SpeakerStock)) {
                while (sc.hasNext()) {
                    line = sc.nextLine();
                    String[] fields = line.split(",");
                    Speaker speakerFromFile = new Speaker(fields[0], fields[1], Boolean.parseBoolean(fields[2]), Boolean.parseBoolean(fields[3]));
                    speakerStock.add(speakerFromFile);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        else {
            try {
                FileWriter out = new FileWriter(SpeakerStock);
                out.close();
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveTVtoFile(){
            exporter.exportFile(TVStock, wrap(fileWriter -> {
        for (TV a : tvStock) {
            fileWriter.write(a.getModelName() + "," + a.getBrand() + "," + a.getScreenSize() +"," + a.getPanelType() +"," + a.getResolution() + "," + a.isSmartTv() + "\n");
        }})); }
    public void saveHeadphonesToFile(){
        exporter.exportFile(HeadphoneStock, wrap(fileWriter -> {
            for (Headphones a : headphoneStock) {
                fileWriter.write(a.getModelName() + "," + a.getBrand()+"," + a.isWireless() + "\n");
            }})); }
    public void saveSpeakerToFile(){
        exporter.exportFile(SpeakerStock, wrap(fileWriter -> {
            for (Speaker a : speakerStock) {
                fileWriter.write(a.getModelName() + "," + a.getBrand()+"," + a.isSmartSpeaker()+"," + a.isBluetooth() + "\n");
            }})); }
    public void saveSoundbarToFile(){
        exporter.exportFile(SoundbarStock, wrap(fileWriter -> {
            for (Soundbar a : soundbarStock) {
                fileWriter.write(a.getModelName() + "," + a.getBrand()+"," + a.getChannels() + "\n");
            }})); }

    public static <T> Consumer<T> wrap(CheckedConsumer<T> checkedFunction) {
        return t -> {
            try {
                checkedFunction.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
class Exporter {
    public void exportFile(File filePath, Consumer<FileWriter> impl) {
        try (FileWriter out = new FileWriter(filePath)) {
            impl.accept(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



