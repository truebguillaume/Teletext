package ch.heigvd.NewsEmitter;

public class NewsCreator {
    public static String getRandomWeatherNews() {
        String[] weatherNewsArray = {
                "Une tempête majeure s'approche de la côte est.",
                "Des vents forts prévus dans la région nord ce soir.",
                "Un front froid se déplace vers le sud, apportant des températures plus basses.",
                "Alerte de pluie torrentielle dans les zones côtières.",
                "Un ciel dégagé et ensoleillé pour la journée.",
                "Prévisions de neige abondante dans les montagnes ce week-end.",
                "Risque de tempêtes de grêle dans certaines régions.",
                "Conditions de brouillard dense signalées sur les autoroutes principales.",
                "Les météorologues annoncent un pic de chaleur record pour demain.",
                "Un système de basse pression entraînera des averses dans l'après-midi.",
                "Vents violents attendus dans les plaines occidentales.",
                "Prévisions de gelées nocturnes dans les régions vallonnées.",
                "Une dépression tropicale se forme dans l'océan Atlantique.",
                "Des précipitations légères sont attendues dans la soirée.",
                "Les températures devraient augmenter progressivement cette semaine.",
                "Les météorologues surveillent une possible formation de tornade.",
                "Un ciel partiellement nuageux pour la majeure partie de la journée.",
                "Prévisions de tempêtes de sable dans le désert.",
                "Une brume matinale peut affecter la visibilité sur les routes.",
                "Conditions météorologiques stables prévues pour les prochains jours.",
                "Des averses intermittentes sont attendues tout au long de la journée.",
                "Alerte de vents violents dans les zones côtières.",
                "Une couverture nuageuse dense prévue dans l'après-midi.",
                "Des températures anormalement élevées signalées dans le sud.",
                "Des conditions ensoleillées avec un ciel dégagé ce soir.",
                "Prévisions de tempête de verglas dans le nord-est.",
                "Les prévisionnistes mettent en garde contre des rafales de vent importantes.",
                "Une humidité élevée peut entraîner des averses intermittentes.",
                "Un front chaud apportera des températures plus élevées dans l'ouest.",
                "Les températures devraient chuter brusquement dans les prochaines heures.",
                "Des nuages d'orage se forment dans les régions montagneuses.",
                "Prévisions de conditions enneigées pour la journée de demain.",
                "Les météorologues surveillent une zone de basse pression au large.",
                "Alerte de vents de tempête dans les vallées orientales.",
                "Des averses légères pourraient débuter dans la soirée.",
                "Un front météorologique apportera des pluies généralisées.",
                "Des précipitations modérées attendues dans la matinée.",
                "Prévisions de gelées matinales dans les régions rurales.",
                "Les vents devraient se calmer dans l'après-midi.",
                "Des orages isolés signalés dans certaines zones.",
                "Un ciel couvert de nuages bas pour la journée.",
                "Des conditions de neige poudreuse dans les stations de ski.",
                "Les températures restent stables avec un ciel partiellement nuageux.",
                "Prévisions de pluies éparses dans les régions du littoral.",
                "Une hausse de l'humidité pourrait entraîner des averses nocturnes.",
                "Un avertissement de givre est en place dans les zones montagneuses.",
                "Des rafales de vent pourraient perturber les déplacements ce soir.",
                "Prévisions de tempête de sable dans les déserts du sud.",
                "Une amélioration des conditions météorologiques attendue demain.",
                "Des nuages d'orage se dissipent progressivement dans l'après-midi."
        };

        int randomIndex = (int) (Math.random() * weatherNewsArray.length);
        return weatherNewsArray[randomIndex];
    }
    public static String getRandomHeigNews() {
        String[] heigNewsArray = {
                "La HEIG-VD lance un nouveau programme de recherche en intelligence artificielle.",
                "Les étudiants de la HEIG-VD remportent le premier prix au concours de robotique national.",
                "Une conférence sur les technologies émergentes aura lieu à la HEIG-VD le mois prochain.",
                "La HEIG-VD obtient une subvention pour développer des solutions durables en ingénierie.",
                "Le département informatique de la HEIG-VD organise un hackathon de 24 heures ce week-end.",
                "Des étudiants de la HEIG-VD contribuent à un projet de développement durable en Afrique.",
                "Un partenariat entre la HEIG-VD et une entreprise locale aboutit à une innovation en énergie solaire.",
                "La HEIG-VD lance un cours en ligne gratuit sur l'introduction à l'internet des objets (IoT).",
                "Des chercheurs de la HEIG-VD publient un article sur la cybersécurité dans une revue renommée.",
                "La HEIG-VD ouvre un laboratoire de réalité virtuelle pour la recherche en ingénierie.",
                "Les étudiants en génie électrique de la HEIG-VD présentent leurs projets lors d'une exposition.",
                "Un alumni de la HEIG-VD devient PDG d'une start-up en plein essor.",
                "La HEIG-VD organise une journée portes ouvertes pour présenter ses programmes d'ingénierie.",
                "Des étudiants de la HEIG-VD remportent un concours de conception d'applications mobiles.",
                "La HEIG-VD élargit son programme de stage international pour les étudiants en génie mécanique.",
                "Un projet de recherche en intelligence artificielle à la HEIG-VD reçoit un financement européen.",
                "La HEIG-VD accueille une conférence sur l'innovation en ingénierie avec des experts internationaux.",
                "Des étudiants de la HEIG-VD participent à un projet de conception de véhicule électrique.",
                "Un laboratoire de recherche en génie civil est inauguré à la HEIG-VD.",
                "La HEIG-VD lance un concours d'innovation ouvert aux étudiants pour des solutions technologiques.",
                "Des enseignants de la HEIG-VD publient un livre sur les avancées en ingénierie logicielle.",
                "Un diplômé de la HEIG-VD reçoit un prix pour ses contributions à l'industrie de l'ingénierie.",
                "La HEIG-VD organise un symposium sur la durabilité et les énergies renouvelables.",
                "Des étudiants de la HEIG-VD développent un prototype de voiture solaire pour une compétition.",
                "La HEIG-VD élargit son réseau de partenariats avec des universités étrangères pour les échanges étudiants.",
                "Un projet de recherche sur l'intelligence artificielle à la HEIG-VD attire l'attention des médias nationaux.",
                "Des étudiants de la HEIG-VD présentent leurs travaux lors d'une conférence sur l'innovation technologique.",
                "La HEIG-VD organise un atelier sur la programmation avancée ouvert à tous les passionnés de technologie.",
                "Des enseignants de la HEIG-VD participent à un projet de numérisation du patrimoine culturel.",
                "La HEIG-VD lance un programme de mentorat pour les étudiants intéressés par l'entrepreneuriat.",
                "Un groupe de recherche de la HEIG-VD travaille sur des solutions pour la mobilité urbaine durable.",
                "Des étudiants en ingénierie de la HEIG-VD présentent leur projet de développement durable à un concours régional.",
                "La HEIG-VD accueille une conférence sur la cybersécurité avec la participation d'experts internationaux.",
                "Des chercheurs de la HEIG-VD développent un prototype de capteur intelligent pour l'agriculture de précision.",
                "La HEIG-VD lance un programme de formation continue en technologie blockchain pour les professionnels.",
                "Un projet de recherche de la HEIG-VD sur les énergies renouvelables est présenté lors d'une conférence mondiale.",
                "Des étudiants en génie mécanique de la HEIG-VD remportent un prix pour leur conception novatrice.",
                "La HEIG-VD organise un événement de réseautage pour les diplômés et les entreprises du secteur de l'ingénierie.",
                "Des enseignants de la HEIG-VD contribuent à un projet international sur l'analyse des mégadonnées en santé.",
                "La HEIG-VD lance un appel à projets pour des innovations dans le domaine de l'intelligence artificielle.",
                "Des étudiants en informatique de la HEIG-VD créent une application pour faciliter l'apprentissage des langues.",
                "La HEIG-VD ouvre un laboratoire de recherche sur la sécurité informatique en collaboration avec l'industrie.",
                "Un symposium sur les véhicules autonomes est organisé à la HEIG-VD avec la participation de professionnels du secteur.",
                "La HEIG-VD lance un projet pilote pour développer des solutions de domotique pour les personnes âgées.",
                "Des étudiants de la HEIG-VD remportent un concours de conception d'algorithmes innovants.",
                "La HEIG-VD accueille une conférence sur les technologies émergentes dans le domaine de la santé.",
                "Un projet de recherche de la HEIG-VD sur les réseaux 5G attire l'attention des industries de télécommunication.",
                "Des enseignants de la HEIG-VD participent à un projet de recherche sur l'intégration de l'IA dans l'éducation.",
                "La HEIG-VD lance un programme de formation en cybersécurité ouvert aux professionnels de l'informatique.",
                "Des étudiants en génie civil de la HEIG-VD présentent leurs solutions pour la construction durable.",
                "La HEIG-VD organise un colloque sur l'innovation et l'entrepreneuriat avec des intervenants du monde de l'industrie.",
                "Des chercheurs de la HEIG-VD publient une étude sur l'utilisation des drones pour la cartographie urbaine."
        };


        int randomIndex = (int) (Math.random() * heigNewsArray.length);
        return heigNewsArray[randomIndex];
    }
    public static String getRandomPoliticNews() {
        String[] politicalNewsArray = {
                "Le gouvernement annonce de nouvelles mesures pour promouvoir l'égalité des sexes sur le lieu de travail.",
                "Des négociations de paix entre deux nations voisines sont en cours pour résoudre les tensions frontalières.",
                "Un projet de loi visant à réformer le système éducatif est présenté au parlement.",
                "Le Premier Ministre annonce des réformes fiscales pour soutenir les petites entreprises.",
                "Une campagne nationale de sensibilisation à l'importance de la santé mentale est lancée par le gouvernement.",
                "Un scandale politique éclate concernant des allégations de corruption au sein du gouvernement.",
                "Des manifestations massives ont lieu pour demander des mesures plus strictes contre le changement climatique.",
                "Un accord commercial majeur est signé entre deux puissances économiques mondiales.",
                "Une réunion internationale se tient pour discuter de la crise migratoire dans certaines régions du monde.",
                "Des discussions sur la réforme des lois sur l'immigration divisent les opinions au sein du gouvernement.",
                "Une nouvelle politique de santé publique est adoptée pour lutter contre l'obésité infantile.",
                "Des élections municipales anticipées sont annoncées dans plusieurs régions du pays.",
                "Une commission parlementaire enquête sur les pratiques de surveillance électronique et la protection de la vie privée.",
                "Le gouvernement annonce des mesures d'urgence pour faire face à une crise économique.",
                "Une proposition de loi pour renforcer les contrôles des armes à feu est débattue au parlement.",
                "Un plan de relance économique est mis en place pour soutenir les industries en difficulté.",
                "Un sommet international sur la sécurité alimentaire est organisé pour lutter contre la famine dans le monde.",
                "Des réformes constitutionnelles sont envisagées pour moderniser le système judiciaire.",
                "Une nouvelle politique de soutien aux familles monoparentales est introduite.",
                "Des pourparlers de paix entre plusieurs factions rivales dans une région en conflit sont en cours.",
                "Une campagne anti-corruption est lancée pour éradiquer les pratiques illicites dans le secteur public.",
                "Des débats houleux au parlement concernent les politiques d'austérité budgétaire.",
                "Le gouvernement annonce des investissements massifs dans les énergies renouvelables.",
                "Une enquête parlementaire examine les implications sociales de l'automatisation dans l'industrie.",
                "Une proposition de loi sur le mariage pour tous est déposée au parlement.",
                "Des réformes électorales visant à moderniser le système de vote sont à l'étude.",
                "Une initiative gouvernementale pour encourager l'entreprenariat chez les jeunes est lancée.",
                "Des négociations commerciales bilatérales entre plusieurs pays aboutissent à un accord historique.",
                "Une réforme du système de santé vise à améliorer l'accès aux soins pour les populations défavorisées.",
                "Une crise diplomatique éclate entre deux nations en raison de différends territoriaux.",
                "Des manifestations populaires réclament une plus grande transparence dans la gestion des fonds publics.",
                "Un programme de lutte contre la pauvreté infantile est annoncé par le gouvernement.",
                "Une loi sur la protection des droits des minorités est discutée au parlement.",
                "Une réunion de l'ONU se concentre sur les défis de la paix et de la sécurité internationales.",
                "Une réforme de la politique d'immigration vise à faciliter l'intégration des réfugiés dans la société."
        };

        int randomIndex = (int) (Math.random() * politicalNewsArray.length);
        return politicalNewsArray[randomIndex];
    }
    public static String getRandomSportNews() {
        String[] sportsNewsArray = {
                "Une équipe de football remporte le championnat national après une saison exceptionnelle.",
                "Un joueur de tennis célèbre atteint la finale d'un tournoi du Grand Chelem pour la première fois de sa carrière.",
                "Un record du monde est battu lors d'une compétition d'athlétisme.",
                "Une équipe de basketball réussit à se qualifier pour les séries éliminatoires après une série de victoires.",
                "Un jeune prodige du golf remporte un tournoi majeur, impressionnant les observateurs du sport.",
                "Un athlète paralympique reçoit une reconnaissance spéciale pour ses réalisations exceptionnelles.",
                "Une équipe de rugby réalise une remontée spectaculaire pour remporter le match dans les dernières minutes.",
                "Une gymnaste talentueuse décroche la médaille d'or dans une compétition internationale.",
                "Un joueur de cricket établit un nouveau record national pour le nombre de points marqués dans un seul match.",
                "Un championnat de surf attire des compétiteurs du monde entier sur les vagues les plus impressionnantes.",
                "Un événement de sports extrêmes est organisé, mettant en vedette des performances incroyables.",
                "Une joueuse de volleyball remporte un prix pour sa contribution exceptionnelle à son équipe.",
                "Un boxeur célèbre annonce son retour sur le ring pour un combat très attendu.",
                "Un joueur d'échecs impressionne en remportant un tournoi international contre des adversaires de haut niveau.",
                "Un marathon caritatif attire des milliers de coureurs pour soutenir une cause importante.",
                "Un jeune coureur de Formule 1 fait ses débuts remarquables en terminant sur le podium.",
                "Une équipe de hockey sur glace crée la surprise en battant le favori du championnat.",
                "Un événement de natation réunit des athlètes du monde entier pour des performances remarquables.",
                "Un joueur de baseball établit un nouveau record de circuits dans une seule saison.",
                "Un tournoi de golf prestigieux voit une compétition acharnée se terminer par un putt décisif.",
                "Un joueur de football américain est nommé MVP après une saison exceptionnelle.",
                "Un tournoi de badminton voit un joueur émerger comme le nouveau prodige du sport.",
                "Un championnat de cyclisme voit des compétiteurs s'affronter dans des étapes difficiles.",
                "Un événement de skateboard met en lumière de jeunes talents avec des figures impressionnantes.",
                "Une joueuse de tennis établit un nouveau record de titres remportés sur une saison.",
                "Un championnat de voile voit des équipes rivaliser pour remporter le trophée prestigieux.",
                "Un joueur de basket-ball étranger signe un contrat lucratif avec une équipe de la NBA.",
                "Un événement de saut à ski voit des athlètes réaliser des performances remarquables sur la piste.",
                "Un joueur de rugby est honoré pour sa longévité et sa contribution au sport.",
                "Un tournoi de billard attire des professionnels pour des parties intenses et stratégiques.",
                "Un tournoi de bowling voit un joueur réaliser un score presque parfait.",
                "Une équipe de football féminin remporte un tournoi international, affirmant sa domination dans le sport.",
                "Un événement de course automobile voit des dépassements audacieux sur le circuit.",
                "Un joueur de golf annonce sa retraite après une carrière illustre sur le green.",
                "Une équipe de cricket célèbre remporte un trophée après une série de performances exceptionnelles.",
                "Un marathon de vélo attire des passionnés pour une course épique à travers les montagnes.",
                "Un joueur de baseball est honoré pour avoir battu un record historique de coups sûrs.",
                "Une équipe de basketball universitaire crée la surprise en battant un adversaire classé numéro un.",
                "Un championnat de natation voit des records personnels établis par de jeunes nageurs prometteurs.",
                "Un joueur de football remporte le titre de meilleur buteur de la saison.",
                "Un tournoi de tennis de table met en lumière des échanges rapides et spectaculaires.",
                "Un joueur de hockey sur glace atteint un nombre impressionnant de points marqués au cours de sa carrière.",
                "Un événement de ski alpin voit des compétiteurs défier des pistes difficiles pour le titre.",
                "Une équipe de basketball de rue remporte un tournoi local après des matchs palpitants.",
                "Un joueur de golf amateur réalise un trou-en-un sur un parcours difficile.",
                "Une compétition de gymnastique rythmique présente des chorégraphies élégantes et artistiques.",
                "Un joueur de tennis reconnu annonce sa retraite après une carrière distinguée sur le circuit.",
                "Une équipe de football réussit à se maintenir dans une ligue de haut niveau malgré les prédictions pessimistes."
                // Ajoutez les autres nouvelles sportives ici...
        };

        int randomIndex = (int) (Math.random() * sportsNewsArray.length);
        return sportsNewsArray[randomIndex];
    }
}
