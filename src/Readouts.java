import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Readouts {


    public static ArrayList<Teilnehmer> getInformationStatischTeilnehmer(String path) {
        ArrayList<Teilnehmer> returnValue = new ArrayList<>();
        String[] s = reader(path);
        for (int i = 0; i < s.length; i++) {
            String[] splitData = s[i].split("[.]");
            String[] finalData = splitData[3].split("=");
            if (splitData[2].equals("tn")) {
                returnValue.add(new Teilnehmer(finalData[1], finalData[0]));
            }
        }
        return returnValue;
    }

    public static ArrayList<Dienste> getInformationStatischDienste(String path) {
        ArrayList<Dienste> returnValue = new ArrayList<>();
        String[] s = reader(path);
        for (int i = 0; i < s.length; i++) {
            String[] splitData = s[i].split("[.]");
            String[] finalData = splitData[3].split("=");
            if (splitData[2].equals("komponente")) {
                returnValue.add(new Dienste(finalData[1], finalData[0]));
            }
        }
        return returnValue;
    }

    public static ArrayList<String> getInformationMak(String path) {
        ArrayList<String> returnValue = new ArrayList<>();
        String[] s = reader(path);
        for (String s1 : s) {
            returnValue.add(s1);
        }

        return returnValue;
    }

    public static ArrayList<Server> getInformationMakServer(String path) {
        boolean d = false;
        ArrayList<Server> returnValue = new ArrayList<>();
        String[] s = reader(path);
        for (int i = 0; i < s.length; i++) {
            String[] splitData = s[i].split("[.]");
            String[] finalData = splitData[3].split("=");
            if (splitData[2].equals("infra")) {
                d = false;
                for (Server server : returnValue) {
                    if (server.getName().contains(finalData[1].toLowerCase())) {
                        d = true;
                    }
                }
                if (!d) {
                    returnValue.add(new Server(finalData[1].toLowerCase()));
                    d = false;
                }

            }
        }

        return returnValue;
    }

    public static Server getServer(String s, ArrayList<Server> servers) {
        String[] split = s.split("=");
        for (Server server : servers) {
            if (server.getName().contains(split[1].toLowerCase())) {
                return server;
            }
        }
        return null;
    }

    private static String[] reader(String path) {
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (!data.startsWith("#") && !data.isEmpty()) {
                    arrayList.add(data);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String[] returnValue = new String[arrayList.size()];
        returnValue = arrayList.toArray(returnValue);

        return returnValue;

    }


}
