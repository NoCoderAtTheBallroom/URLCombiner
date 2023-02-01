import java.util.ArrayList;
import java.util.SplittableRandom;

public class Builder {


    public ArrayList<Connector> getInformation(String s, ArrayList<Server> servers, ArrayList<Teilnehmer> teilnehmers, ArrayList<Dienste> dienstes){
        s = s.toLowerCase();
        Server server = null;
        Teilnehmer teilnehmer = null;
        Dienste dienste = null;
        boolean alles = false;
        String[] split = s.split("[.]");
        for (Dienste di :dienstes) {
            if(split[0].contains(di.getName())){
                dienste = di;
            }
        }
        for (Teilnehmer te :teilnehmers) {
            if(split[1].contains(te.getName())){
                teilnehmer = te;
            }
            if(split[1].contains("alle")){
                alles = true;
            }
        }
        String[] split2 = split[3].split("=");
        for (Server se : servers) {
            if(split2[1].contains(se.getName())){
                server = se;
            }
        }
        ArrayList<Connector> arrayList = new ArrayList<>();

        if(alles){
            for (Teilnehmer t : teilnehmers) {
                arrayList.add(new Connector(t,server,dienste));
            }

        }else{
            arrayList.add(new Connector(teilnehmer,server,dienste));
        }




        return arrayList;
    }
}
