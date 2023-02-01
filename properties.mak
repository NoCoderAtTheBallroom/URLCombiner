# Kommentar
# So wird Dienst1 für alle Teilnehmer auf Server1 konfiguriert, nur für tn1 auf Server2
Dienst1.alle.infra.maschinen=Server1
Dienst1.tn1.infra.maschinen=Server2

# Dienst 2 wird nur für tn1 und tn2 konfiguriert, die anderen Teilnehmer haben diesen Dienst nicht
Dienst2.tn1.infra.maschinen=Server1
Dienst2.tn2.infra.maschinen=Server3

# Dienst 3 wird nur für tn3 konfiguriert
Dienst3.tn3.infra.maschinen=Server3

Dienst4.tn4.infra.maschinen=Server1
Dienst4.tn3.infra.maschinen=Server2
Dienst4.tn2.infra.maschinen=Server3
Dienst4.tn1.infra.maschinen=Server4

Dienst5.alle.infra.maschinen=Server7
Dienst5.tn1.infra.maschinen=Server1
Dienst5.tn2.infra.maschinen=Server2
Dienst5.tn3.infra.maschinen=Server3
Dienst5.tn4.infra.maschinen=Server4


# usw.