import java.util.ArrayList;

public class Handler {

    public Handler(String statischFile, String makFile, int portPrevalue) {
        ArrayList<Teilnehmer> arrayListTeilnehmer = Readouts.getInformationStatischTeilnehmer(statischFile);
        ArrayList<Dienste> arrayListDienste = Readouts.getInformationStatischDienste(statischFile);
        ArrayList<Server> arrayListServer = Readouts.getInformationMakServer(makFile);
        ArrayList<String> arrayListRaw = Readouts.getInformationMak(makFile);

        Builder builder = new Builder();

        ArrayList<Connector> connector = new ArrayList<>();
        Boolean b = false;


        for (String s : arrayListRaw) {
            String[] split = s.split("[.]");


            for (Connector c : connector) {
                if (c.getTeilnehmer().getName().contains(split[1].toLowerCase()) && c.getDienste().getName().contains(split[0].toLowerCase())) {
                    c.setServer(Readouts.getServer(s, arrayListServer));
                    b = true;
                }
            }

            if (!b) {
                connector.addAll(builder.getInformation(s, arrayListServer, arrayListTeilnehmer, arrayListDienste));
            }
            b = false;


            System.out.println(connector);
        }
        for (Connector c :
                connector) {
            System.out.println(c.getURL(portPrevalue));
        }


    }
}

