# Kommentar
# So wird Dienst1 für alle Teilnehmer auf Server1 konfiguriert, nur für tn1 auf Server2
Dienst1.alle.infra.maschinen=Server1
Dienst1.tn1.infra.maschinen=Server2

# Dienst 2 wird nur für tn1 und tn2 konfiguriert, die anderen Teilnehmer haben diesen Dienst nicht
Dienst2.tn1.infra.maschinen=Server1
Dienst2.tn2.infra.maschinen=Server3

# Dienst 3 wird nur für tn3 konfiguriert
Dienst3.alle.infra.maschinen=Server1
Dienst3.tn2.infra.maschinen=Server2
Dienst3.tn3.infra.maschinen=Server3

# usw.