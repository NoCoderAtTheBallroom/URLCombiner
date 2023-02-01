public class Connector {

    private Teilnehmer teilnehmer;
    private Server server;
    private Dienste dienste;

    public Connector(Teilnehmer teilnehmer, Server server, Dienste dienste) {
        this.teilnehmer = teilnehmer;
        this.server = server;
        this.dienste = dienste;
    }

    public Dienste getDienste() {
        return dienste;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Server getServer() {
        return server;
    }

    public Teilnehmer getTeilnehmer() {
        return teilnehmer;
    }

    public String getURL(int portPrevalue){
        return "http://" + server.getName() + ":" + portPrevalue + teilnehmer.getPort() + dienste.getPort();
    }
}
