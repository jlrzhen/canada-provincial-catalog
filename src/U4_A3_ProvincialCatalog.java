/*
 * Name: Jeffrey Zhen
 * Date: 11 July 2020
 * Title: Activity 3 Assignment 1
 * Purpose: Teach a lesson to grade nine students
 */

// Imports
import java.awt.Color;
import javax.swing.BorderFactory;
import java.text.*;

public class U4_A3_ProvincialCatalog extends javax.swing.JFrame {
    
    public U4_A3_ProvincialCatalog() {
        initComponents();
    }
    
    // For quiz
    int intQuestionsAsked;
    int intCorrectAnswers = 0;
    
    int intQuizProvince;
    String[] strQuizProvince = {"Alberta", "British Colombia", "Manitoba", 
        "New Brunswick", "Newfoundland and Labrador", "Northwest Territories", 
        "Nova Scotia", "Nunavut", "Ontario", "Prince Edward Island", "Quebec", 
        "Saskatchewan", "Yukon" };

    int intQuestionType;
    String[] strQuestionType = {"Number of Provinces", "Capital City", "Province Region"};
  
    boolean[] blnEncounteredProvince = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};
    
    // Counter for province list
    boolean blnQuizUnlocked = false;
    int intProvincePagesReadByUser = 0;
    boolean[] blnProvincePageReadByUser = {false, false, false, false, false, false, false, false, false, false, false, false, false};
        
    // Population of each province (Q2 2020, thousands)
    // Source: https://www150.statcan.gc.ca/t1/tbl1/en/cv.action?pid=1710000901
    int[] intProvincePopulation = {4428, 5120, 1379, 780, 520, 44, 978, 39, 14745, 158, 8552, 1181, 41};
    DecimalFormat dcmlfrmtPopulation = new DecimalFormat("###,###,###"); 
        
    // Capital Cities
    // Source: https://www.canada.ca/en/immigration-refugees-citizenship/corporate/publications-manuals/discover-canada/read-online/canadas-regions.html
    String[] strProvinceCapitalCity = {"Edmonton", "Victoria", "Winnipeg", "Fredericton", "St. John's", "Yellowknife", "Halifax", "Iqaluit", "Toronto", "Charlottetown","Quebec City", "Regina", "Whitehorse"};
        
    // Assign regions to provinces
    String[] strProvinceRegion = {"Prarie", "West Coast", "Prarie", "Atlantic", "Atlantic", "North", "Atlantic", "North", "Central", "Atlantic", "Central", "Prarie", "North"};
    
    // Resets background panel
    public void backgroundRefresh() {
        this.pnlBackground.repaint();
        this.pnlBackground.revalidate();
    }
    
    // Returns to main menu page
    public void returnToMainMenu() {
        this.pnlBackground.removeAll();
        this.pnlBackground.add(this.pnlMainMenu);
        
        // Show quiz if all provicnce pages have been read by user
        if(blnQuizUnlocked == true) {
            this.pnlMainMenuQuiz.setVisible(true);
        } 
        else if(blnQuizUnlocked == false) {
            this.pnlMainMenuQuiz.setVisible(false);
        }
        
        this.pnlBackground.repaint();
        this.pnlBackground.revalidate();
    }
    
    // Displays appropriate data in province page
    public void showProvinceData(String strSelectedProvince) {
        
        // Switch to information page
        this.pnlBackground.removeAll();
        this.pnlBackground.add(this.pnlProvinceDataPage);
        
        // Assign numbers to provinces (for use in arrays)
        int intProvinceNum;
        switch(strSelectedProvince){
            case "Alberta":
                intProvinceNum = 0;  
                break;
            case "British Colombia":
                intProvinceNum = 1;
                break;
            case "Manitoba":
                intProvinceNum = 2;
                break;
            case "New Brunswick":
                intProvinceNum = 3;
                break;
            case "Newfoundland and Labrador":
                intProvinceNum = 4;
                break;
            case "Northwest Territories":
                intProvinceNum = 5;
                break;
            case "Nova Scotia":
                intProvinceNum = 6;
                break;
            case "Nunavut":
                intProvinceNum = 7;
                break;
            case "Ontario":
                intProvinceNum = 8;
                break;
            case "Prince Edward Island":
                intProvinceNum = 9;
                break;
            case "Quebec":
                intProvinceNum = 10;
                break;
            case "Saskatchewan":
                intProvinceNum = 11;
                break;
            case "Yukon":
                intProvinceNum = 12;
                break;
            default:
                intProvinceNum = 13;
        }
        
        // Determine climate based on region
        /* Sources: https://www.cravecanada.com/travel-info/climate-of-canada/
         *          https://en.wikipedia.org/wiki/Northern_Canada#Climate
         *          https://en.wikipedia.org/wiki/Canadian_Prairies#:~:text=The%20majority%20of%20the%20prairie,climates%20with%20warm%20summers%2C%20Dfb.
         */
        String strProvinceClimate;
      
        switch(strProvinceRegion[intProvinceNum]) {
            // Source: https://stackoverflow.com/questions/1090098/newline-in-jlabel
            case "Atlantic":
                strProvinceClimate = "Short summers of approximately six-week duration, "
                    + "high winds, sudden rain and snow storms. "
                    + "Summers are likely to be humid, sunny and mild.</html>";
                break;
            case "Central":
                strProvinceClimate = "Sun shines brightly on a summer day and most winter days are sunny as well. "
                    + "In winter, there is very little rain and a snowfall from 20 to 23 inches from December through March. "
                    + "Light wind, moderate humidity and fairly stable temperatures in winter and sunny summers.</html>";
                break;
            case "Prarie":
                strProvinceClimate = "Snowy, fully humid continental climates with cool summers. "
                    + "Fully humid continental climates with warm summers. "
                    + "On average, 454 mm of precipitation falls each year. "
                    + "Most rainfall typically happens in the summer months such as June and July.</html>";
                break;
            case "West Coast":
                strProvinceClimate = "Warm dry summers. Winters often bring sub-sub-zero temperatures. "
                    + "Snowfall is irregular, summer rainfall is sparse often causing drought. "
                    + "A summer day may begin with pleasant, dry temperatures and end with a light snowfall even in August. "
                    + "Autumn offers a gentle wind and a riot of colourful foliage in oranges and gold.</html>";
                break;
            case "North":
                strProvinceClimate = "Snow and ice-covered, "
                    + "with temperatures generally remaining below the freezing mark from October to May. "
                    + "Snowfall is often light in nature. "
                    + "In the summer months, temperatures average below 45 degrees Fahrenheit "
                    + "(7.2 degrees Celsius) and may occasionally exceed 65 degrees Fahrenheit (18.3 degrees Celsius). "
                    + "Most of the rainfall accumulated occurs in the summer months.</html>";
                break;
            default:
                strProvinceClimate = "null";
        }
        
        // Fun facts
        // Source: https://www.sporcle.com/blog/2018/12/interesting-facts-about-canadian-provinces/
        String strFunFacts;
        
        switch(strSelectedProvince) {
            case "Alberta":
                strFunFacts = "<html>-Over half the population lives in only two cities. "
                    + "Despite having quite a large population of 4.28 million people, "
                    + "over 60 percent of the entire provincial population of Alberta lives"
                    + " in the cities of Calgary and Edmonton.<br/><br/>" 
                    + "-It has the oldest national park in Canada. "
                    + "Alberta happens to be home to five beautiful national parks, "
                    + "but only one of them gets the coveted title of the oldest national park in the entire country. "
                    + "Banff National Park was officially established way back in 1885 and is not only the oldest national "
                    + "park in Canada, but the fourth oldest national park in the world as well.</html>";
                break;
            case "British Colombia":
                strFunFacts = "<html>-British Colombia was the last province to host the Olympics. "
                    + "Canada has only hosted the Olympics three times in history. "
                    + "The first being in Montreal in 1976, the second being in Calgary in 1988, "
                    + "and the third and last time being in Vancouver in 2010.</html>";
                break;
            case "Manitoba": 
                strFunFacts = "<html>-There are over 100,000 lakes. "
                    + "Throughout the entire province of Manitoba, "
                    + "there are scattered lakes of all sizes. "
                    + "If you added them all up, there would be over 100,000 of them! "
                    + "It is estimated that as many as 90 percent of them still remain nameless.<br/><br/>"
                    + "-It is the polar bear capital of the world. "
                    + "The extremely cold winter temperatures of this prairie province make it ideal "
                    + "for the country's population of polar bears to settle. The northern town of Churchill, "
                    + "Manitoba is known as the polar bear capital of the world.</html>";
                break;
            case "New Brunswick":
                strFunFacts = "<html>-It is the only bilingual province. "
                    + "Despite Quebec's extremely large French population, "
                    + "it is not officially a bilingual province. "
                    + "New Brunswick is the only province in Canada that includes "
                    + "both French and English as its official languages.<br/><br/>" 
                    + "-Over 80 percent of the province is covered in forest. "
                    + "Due to its close proximity to the ocean, New Brunswick is "
                    + "suitable for trees to flourish. This has resulted in about "
                    + "83 percent of the province being covered in forest.</html>";
                break;
            case "Newfoundland and Labrador":
                strFunFacts = "<html>-The last province to join Canada. "
                    + "Despite being one of the first Canadian areas to be settled by European explorers, "
                    + "the province was not officially entered as a part of the Canadian Confederation until 1949.<br/><br/>"
                    + "-It has the oldest city in Canada. The capital city of St. John's is not only the oldest city in Canada, "
                    + "but among the oldest in all of North America, existing on maps as early as 1519.</html>";
                break;
            case "Northwest Territories":
                strFunFacts = "<html>-It is the diamond capital of North America. "
                    + "The northern area was once known for its large gold mining operation "
                    + "but has since switched its shift to diamonds and become the diamond capital of North America.</html>";
                break;
            case "Nova Scotia":
                strFunFacts = "<html>-It was once French. "
                    + "The tiny Atlantic province was once ruled by the French monarchy "
                    + "when it was settled by French explorers in 1605. Then starting in 1654, "
                    + "the British Empire launched an invasion on the area and overtook power from the French.</html>";
                break;
            case "Nunavut":
                strFunFacts = "<html>-It did not exist until 1999. Up until almost the turn of the century, "
                    + "the only two territories in Canada were the Northwest Territories and Yukon. "
                    + "It was not until 1999 that the Northwest Territories was split up and the largest "
                    + "chunk of it was renamed Nunavut.</html>";
                break;
            case "Ontario":
                strFunFacts = "<html>-It borders the most US states. "
                    + "With such a massive horizontal span, it is no wonder that "
                    + "Ontario holds the record for highest number of bordering US states. "
                    + "A total of five states border this province, despite the fact that "
                    + "three of them share no land border and are instead separated only by water.<br/><br/>" 
                    + "-It is the nickel capital of the world. Those famous Canadian nickels had to come from somewhere, "
                    + "despite being only about 2 percent actual nickel. Currently, it turns out that place is in Ontario. "
                    + "The town of Sudbury, Ontario, is the nickel capital of the world.</html>";
                break;
            case "Prince Edward Island":
                strFunFacts = "<html>-It is the smallest province. "
                    + "Made up of only one island, the province of Prince Edward Island is "
                    + "by far the smallest province in Canada with a total area of only 5,660 square kilometers "
                    + "and a population of just over 150,000 people.</html>";
                break;
            case "Quebec":
                strFunFacts = "<html>-It has French as its official language. "
                    + "The Official Language Act was passed in 1974. "
                    + "This made French the official language of Quebec rather than English.</html>";
                break;
            case "Saskatchewan":
                strFunFacts = "<html>-It is responsible for the training of the RCMP. "
                        + "Even though the Royal Canadian Mounted Police headquarters building is located in Ontario, "
                        + "the RCMP training facility is located in Regina, Saskatchewan.</html>";
                break;
            case "Yukon":
                strFunFacts = "<html>-There is no sun for 24 hours. Due to its close proximity to the Arctic Circle, "
                        + "the territory of Yukon experiences midnight sun, meaning it has one day a year "
                        + "where the sun remains risen for 24 hours. Conversely, they also have one day a year "
                        + "where the sun remains hidden for 24 hours.</html>";
                break;
            default:
              strFunFacts = "Fun Facts";   
        }
        
        // Display information about province
        this.lblProvinceDataPageTitle.setText(strSelectedProvince);
        this.lblProvinceDataPagePopulation.setText("Population (thousands): " + 
            dcmlfrmtPopulation.format(intProvincePopulation[intProvinceNum]));
        this.lblProvinceDataPageCapitalCity.setText("Capital City: " + 
            strProvinceCapitalCity[intProvinceNum]);
        this.lblProvinceDataPageClimate.setText("<html><b>Climate:</b> " + strProvinceClimate);
        this.lblProvinceDataPageFunFacts.setText(strFunFacts);
        
         // Display Image
        switch(strSelectedProvince){
            case "Alberta":
                this.pnlProvinceDataPageImage.removeAll();
                // Source: https://www.macleans.ca/economy/where-to-live-alberta-canada-best-communities-2019/
                this.pnlProvinceDataPageImage.add(this.pnlProvinceDataAlbertaImage);
                break;
            case "British Colombia":
                this.pnlProvinceDataPageImage.removeAll();
                // Source: https://www.wendyperrin.com/?destination=british-columbia-travel-guide-marc-telio
                this.pnlProvinceDataPageImage.add(this.pnlProvinceDataBritishColombiaImage);
                break;
            case "Manitoba": 
                // Source: https://matadornetwork.com/destinations/north-america/canada/manitoba/
                this.pnlProvinceDataPageImage.removeAll();
                this.pnlProvinceDataPageImage.add(this.pnlProvinceDataManitobaImage);
                break;
            case "New Brunswick":
                this.pnlProvinceDataPageImage.removeAll();
                // Source: https://www.immigration.ca/new-brunswick-immigration
                this.pnlProvinceDataPageImage.add(this.pnlProvinceDataNewBrunswickImage);
                break;
            case "Newfoundland and Labrador":
                this.pnlProvinceDataPageImage.removeAll();
                // Source: https://www.nationalgeographic.com/travel/destinations/north-america/canada/newfoundland-labrador/
                this.pnlProvinceDataPageImage.add(this.pnlProvinceDataNewfoundlandAndLabradorImage);
                break;
            case "Northwest Territories":
                this.pnlProvinceDataPageImage.removeAll();
                // Source: https://www.tripadvisor.ca/LocationPhotos-g154965-Northwest_Territories.html
                this.pnlProvinceDataPageImage.add(this.pnlProvinceDataNorthwestTerritoriesImage);
                break;
            case "Nova Scotia":
                this.pnlProvinceDataPageImage.removeAll();
                // Source: https://o.canada.com/travel/9-photos-of-nova-scotia-thatll-make-you-want-to-visit-the-maritimes-this-summer
                this.pnlProvinceDataPageImage.add(this.pnlProvinceDataNovaScotiaImage);
                break;
            case "Nunavut":
                this.pnlProvinceDataPageImage.removeAll();
                // Source: https://financialpost.com/commodities/mining/vast-wealth-nunavut-at-a-crossroads-when-it-comes-to-untapped-mineral-riches 
                this.pnlProvinceDataPageImage.add(this.pnlProvinceDataNunavutImage);
                break;
            case "Ontario":
                this.pnlProvinceDataPageImage.removeAll();
                // Source: https://www.blogto.com/city/2018/07/toronto-might-secede-ontario-and-become-its-own-province/
                this.pnlProvinceDataPageImage.add(this.pnlProvinceDataOntarioImage);
                break;
            case "Prince Edward Island":
                this.pnlProvinceDataPageImage.removeAll();
                // Source: https://www.hollandamerica.com/en_US/ports/charlottetown-prince-edward-island-canada.html
                this.pnlProvinceDataPageImage.add(this.pnlProvinceDataPrinceEdwardIslandImage);
                break;
            case "Quebec":
                this.pnlProvinceDataPageImage.removeAll();
                // Source: https://www.arrivalguides.com/en/Travelguides/North_America/Canada/Quebec 
                this.pnlProvinceDataPageImage.add(this.pnlProvinceDataQuebecImage);
                break;
            case "Saskatchewan":
                this.pnlProvinceDataPageImage.removeAll();
                // Source: https://www.canadianbusiness.com/lists-and-rankings/growth-500/2019-saskatchewan-fastest-growing-companies/
                this.pnlProvinceDataPageImage.add(this.pnlProvinceDataSaskatchewanImage);
                break;
            case "Yukon":
                this.pnlProvinceDataPageImage.removeAll();
                // Source: https://www.britannica.com/place/Dawson-Yukon
                this.pnlProvinceDataPageImage.add(this.pnlProvinceDataYukonImage);
                break;
            default:
                this.pnlProvinceDataPageImage.removeAll();
                
            /*
             * Sources for images in province selection screen (was unable to include in auto-generated code):
             *
             * Alberta: https://www.cbc.ca/news/canada/calgary/cold-weather-alberta-calgary-edmonton-1.5424376
             * British Colombia: https://www.completenorthamerica.com/6-reasons-to-visit-beautiful-british-columbia/
             * Manitoba: https://thepienews.com/news/manitoba-declares-2019-year-intled/
             * New Brunswick: https://www.thecanadianencyclopedia.ca/en/timeline/new-brunswick
             * Newfoundland and Labrador: https://www.cbc.ca/news/canada/newfoundland-labrador/n-l-tourism-campaign-wins-national-advertising-award-1.1184323
             * Northwest Territories: https://spectacularnwt.com/
             * Nova Scotia: https://www.theguardian.com/discover-cool-canada/2018/nov/01/the-lowdown-on-nova-scotia-canadas-seaside-paradise
             * Nunavut: https://photorator.com/photo/28860/baffin-island-nunavut-canada-
             * Ontario: https://www.officeholidays.com/holidays/canada/ontario/civic-holiday
             * Prince Edward Island: https://themontrealeronline.com/2016/09/prince-edward-island-a-national-treasure-where-theres-always-more-to-discover/
             * Quebec: https://www.worldtravelguide.net/guides/north-america/canada/quebec/
             * Saskatchewan: https://globalnews.ca/news/7114217/your-saskatchewan-photo-july-2020/
             * Yukon: https://www.fodors.com/world/north-america/canada/experiences/news/10-ways-canadas-yukon-territory-is-beyond-your-wildest-dreams                
             */
        }
        
        backgroundRefresh();
    }
    
    // Displays a new question in a quiz
    public void showNewQuestion() {
        // Select province from random number
        intQuizProvince = (int) Math.floor(Math.random() * 13);
        
        // Choose random question type for quiz
        intQuestionType = (int) Math.floor((Math.random() * 2) + 1);
        
        if(strQuestionType[intQuestionType].equals("Capital City")) {
            this.pnlQuestionBox.removeAll();
            pnlQuestionBox.add(this.pnlCapitalCityAnswer);
            
            // Ask for capital city of random province
            this.lblQuizQuestion.setText("Question " + (intQuestionsAsked + 1) + "/14: What is the capital city of " + 
             strQuizProvince[intQuizProvince] + "?");
        }
        else if(strQuestionType[intQuestionType].equals("Province Region")) {
            this.pnlQuestionBox.removeAll();
            pnlQuestionBox.add(this.pnlProvinceRegionAnswer);
            
            // Ask for region of random province
            this.lblQuizQuestion.setText("Question " + (intQuestionsAsked + 1) + "/14: What region of Canada is " + 
             strQuizProvince[intQuizProvince] + " in?");
        }
    }
    
    // Checks a question in quiz
    public void checkQuestion() {
        switch (strQuestionType[intQuestionType]) {
            case "Capital City":
                String strCapitalCityAnswer = this.txtCapitalCityAnswer.getText();
                if(strCapitalCityAnswer.equals(strProvinceCapitalCity[intQuizProvince])) {
                    System.out.println("correct");
                    intCorrectAnswers++;
                    intQuestionsAsked++;
                    this.txtCapitalCityAnswer.setText("");
                    showQuestionResult(true);
                }
                else {
                    System.out.println("incorrect");
                    intQuestionsAsked++;
                    this.txtCapitalCityAnswer.setText("");
                    showQuestionResult(false);
                }   
                break;
            case "Province Region":
                String strProvinceRegionAnswer = this.txtProvinceRegionAnswer.getText();
                if(strProvinceRegionAnswer.equals(strProvinceRegion[intQuizProvince])) {
                    System.out.println("correct");
                    intCorrectAnswers++;
                    intQuestionsAsked++;
                    this.txtProvinceRegionAnswer.setText("");
                    showQuestionResult(true);
                }
                else {
                    System.out.println("incorrect");
                    intQuestionsAsked++;
                    this.txtProvinceRegionAnswer.setText("");
                    showQuestionResult(false);
                }   
                break;
            case "Number of Provinces":
                
                // If text box is blank, mark as incorrect and proceed to next question
                try {
                    int intNumberOfProvincesAnswer = Integer.parseInt(this.txtNumberOfProvincesAnswer.getText());
                    if(intNumberOfProvincesAnswer == strQuizProvince.length) {
                        System.out.println("correct");
                        intCorrectAnswers++;
                        intQuestionsAsked++;
                        this.txtNumberOfProvincesAnswer.setText("");
                        showQuestionResult(true);
                    }
                    else {
                        System.out.println("incorrect");
                        intQuestionsAsked++;
                        this.txtNumberOfProvincesAnswer.setText("");
                        showQuestionResult(false);
                    } 
                }
                catch(Exception e) {
                    System.out.println("incorrect");
                    intQuestionsAsked++;
                    this.txtNumberOfProvincesAnswer.setText("");
                    showQuestionResult(false);
                }
                break;
            default:
                break;
        }
    }
    
    // Tells user wheter answer is correct or incorrect
    public void showQuestionResult(boolean blnAnswerCorrect) {
        if(blnAnswerCorrect == true) {
            this.pnlQuestionBox.removeAll();
            this.pnlQuizButtonArea.removeAll();
            this.lblQuizQuestion.setText("Correct!");
            this.pnlQuizButtonArea.add(this.pnlAfterAnswerButtons);
        }
        else if(blnAnswerCorrect == false) {
            switch (strQuestionType[intQuestionType]) {
                case "Capital City":
                    this.pnlQuestionBox.removeAll();
                    this.pnlQuizButtonArea.removeAll();
                    this.lblQuizQuestion.setText("Incorrect, the answer was \"" + strProvinceCapitalCity[intQuizProvince] + "\".");
                    this.pnlQuizButtonArea.add(this.pnlAfterAnswerButtons);
                    break;
                case "Province Region":
                    this.pnlQuestionBox.removeAll();
                    this.pnlQuizButtonArea.removeAll();
                    this.lblQuizQuestion.setText("Incorrect, the answer was \"" + strProvinceRegion[intQuizProvince] + "\".");
                    this.pnlQuizButtonArea.add(this.pnlAfterAnswerButtons);
                    break;
                case "Number of Provinces":
                    this.pnlQuestionBox.removeAll();
                    this.pnlQuizButtonArea.removeAll();
                    this.lblQuizQuestion.setText("Incorrect, the answer was \"" + strQuizProvince.length + "\".");
                    this.pnlQuizButtonArea.add(this.pnlAfterAnswerButtons);
                    break;
            }
        }
    }
    
    // Checks to see if question has been answered in quiz, skips questions if already answered
    public void checkEncountered() {
        if(blnEncounteredProvince[intQuizProvince] == false) {
            blnEncounteredProvince[intQuizProvince] = true;
        }
        else if(blnEncounteredProvince[intQuizProvince] == true) {
            showNewQuestion();
            backgroundRefresh();
            checkEncountered();
        }
    }
    
    public void resetQuiz() {
        intCorrectAnswers = 0;
        intQuestionsAsked = 0;
        
        int i;
        for(i=0; i < 14; i++) {
            blnEncounteredProvince[i] = false;
        }
    }
    
    /**
     * Creates new form U4_A3_ProvincialCatalog
     */
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        pnlMainMenu = new javax.swing.JPanel();
        pnlMainMenuTop = new javax.swing.JPanel();
        pnlMainMenuTitle = new javax.swing.JLabel();
        pnlMainMenuBottom = new javax.swing.JPanel();
        pnlMainMenuStart = new javax.swing.JPanel();
        lblMainMenuStart = new javax.swing.JLabel();
        pnlMainMenuQuiz = new javax.swing.JPanel();
        lblMainMenuQuiz = new javax.swing.JLabel();
        pnlProvinceList = new javax.swing.JPanel();
        pnlProvinceListTop = new javax.swing.JPanel();
        lblProvinceListTitle = new javax.swing.JLabel();
        pnlProvinceListMainMenuButton = new javax.swing.JPanel();
        lblProvinceListMainMenuButton = new javax.swing.JLabel();
        pnlProvinceListQuizStatus = new javax.swing.JPanel();
        lblProvinceListQuizStatus = new javax.swing.JLabel();
        pnlProvinceListBottom = new javax.swing.JPanel();
        pnlSelectAlberta = new javax.swing.JPanel();
        lblSelectAlberta = new javax.swing.JLabel();
        lblSelectAlbertaImage = new javax.swing.JLabel();
        pnlSelectBritishColombia = new javax.swing.JPanel();
        lblSelectBritishColombia = new javax.swing.JLabel();
        lblSelectBritishColombiaImage = new javax.swing.JLabel();
        pnlSelectManitoba = new javax.swing.JPanel();
        lblSelectManitoba = new javax.swing.JLabel();
        lblSelectManitobaImage = new javax.swing.JLabel();
        pnlSelectNewBrunswick = new javax.swing.JPanel();
        lblSelectNewBrunswick = new javax.swing.JLabel();
        lblSelectNewBrunswickImage = new javax.swing.JLabel();
        pnlSelectNewfoundlandAndLabrador = new javax.swing.JPanel();
        lblSelectNewfoundlandAndLabrador = new javax.swing.JLabel();
        lblSelectNewfoundlandAndLabradorImage = new javax.swing.JLabel();
        pnlSelectNorthwestTerritories = new javax.swing.JPanel();
        lblSelectNorthwestTerritories = new javax.swing.JLabel();
        lblSelectNorthwestTerritoriesImage = new javax.swing.JLabel();
        pnlSelectNovaScotia = new javax.swing.JPanel();
        lblSelectNovaScotia = new javax.swing.JLabel();
        lblSelectNovaScotiaImage = new javax.swing.JLabel();
        pnlSelectNunavut = new javax.swing.JPanel();
        lblSelectNunavut = new javax.swing.JLabel();
        lblSelectNunavutImage = new javax.swing.JLabel();
        pnlSelectOntario = new javax.swing.JPanel();
        lblSelectOntario = new javax.swing.JLabel();
        lblSelectOntarioImage = new javax.swing.JLabel();
        pnlSelectPrinceEdwardIsland = new javax.swing.JPanel();
        lblSelectPrinceEdwardIsland = new javax.swing.JLabel();
        lblSelectPrinceEdwardIslandImage = new javax.swing.JLabel();
        pnlSelectQuebec = new javax.swing.JPanel();
        lblSelectQuebec = new javax.swing.JLabel();
        lblSelectQuebecImage = new javax.swing.JLabel();
        pnlSelectSaskatchewan = new javax.swing.JPanel();
        lblSelectSaskatchewan = new javax.swing.JLabel();
        lblSelectSaskatchewanImage = new javax.swing.JLabel();
        pnlSelectYukon = new javax.swing.JPanel();
        lblSelectYukon = new javax.swing.JLabel();
        lblSelectYukonImage = new javax.swing.JLabel();
        pnlProvinceDataPage = new javax.swing.JPanel();
        pnlProvinceDataMainMenuButton = new javax.swing.JPanel();
        lblProvinceDataMainMenuButton = new javax.swing.JLabel();
        pnlProvinceDataBackButton = new javax.swing.JPanel();
        lblProvinceDataBackButton = new javax.swing.JLabel();
        pnlProvinceDataPageImage = new javax.swing.JPanel();
        pnlProvinceDataAlbertaImage = new javax.swing.JPanel();
        lblProvinceDataAlbertaImage = new javax.swing.JLabel();
        pnlProvinceDataBritishColombiaImage = new javax.swing.JPanel();
        lblProvinceDataBritishColombiaImage = new javax.swing.JLabel();
        pnlProvinceDataManitobaImage = new javax.swing.JPanel();
        lblProvinceDataManitobaImage = new javax.swing.JLabel();
        pnlProvinceDataNewBrunswickImage = new javax.swing.JPanel();
        lblProvinceDataNewBrunswickImage = new javax.swing.JLabel();
        pnlProvinceDataNewfoundlandAndLabradorImage = new javax.swing.JPanel();
        lblProvinceDataNewfoundlandAndLabradorImage = new javax.swing.JLabel();
        pnlProvinceDataNorthwestTerritoriesImage = new javax.swing.JPanel();
        lblProvinceDataNorthwestTerritoriesImage = new javax.swing.JLabel();
        pnlProvinceDataNovaScotiaImage = new javax.swing.JPanel();
        lblProvinceDataNovaScotiaImage = new javax.swing.JLabel();
        pnlProvinceDataNunavutImage = new javax.swing.JPanel();
        lblProvinceDataNunavutImage = new javax.swing.JLabel();
        pnlProvinceDataOntarioImage = new javax.swing.JPanel();
        lblProvinceDataOntarioImage = new javax.swing.JLabel();
        pnlProvinceDataPrinceEdwardIslandImage = new javax.swing.JPanel();
        lblProvinceDataPrinceEdwardIslandImage = new javax.swing.JLabel();
        pnlProvinceDataQuebecImage = new javax.swing.JPanel();
        lblProvinceDataQuebecImage = new javax.swing.JLabel();
        pnlProvinceDataSaskatchewanImage = new javax.swing.JPanel();
        lblProvinceDataSaskatchewanImage = new javax.swing.JLabel();
        pnlProvinceDataYukonImage = new javax.swing.JPanel();
        lblProvinceDataYukonImage = new javax.swing.JLabel();
        pnlProvinceDataPageInformation = new javax.swing.JPanel();
        lblProvinceDataPagePopulation = new javax.swing.JLabel();
        lblProvinceDataPageCapitalCity = new javax.swing.JLabel();
        lblProvinceDataPageClimate = new javax.swing.JLabel();
        lblProvinceDataPageFunFacts = new javax.swing.JLabel();
        lblProvinceDataFunFactsTitle = new javax.swing.JLabel();
        pnlProvinceDataPageTitle = new javax.swing.JPanel();
        lblProvinceDataPageTitle = new javax.swing.JLabel();
        pnlQuiz = new javax.swing.JPanel();
        lblQuizQuestion = new javax.swing.JLabel();
        pnlQuizMainMenuButton = new javax.swing.JPanel();
        lblQuizMainMenuButton = new javax.swing.JLabel();
        pnlQuizQuestionContainer = new javax.swing.JPanel();
        pnlQuestionBox = new javax.swing.JPanel();
        pnlNumberOfProvincesAnswer = new javax.swing.JPanel();
        lblRequestNumberOfProvinces = new javax.swing.JLabel();
        txtNumberOfProvincesAnswer = new javax.swing.JTextField();
        pnlCapitalCityAnswer = new javax.swing.JPanel();
        lblRequestCapitalCity = new javax.swing.JLabel();
        txtCapitalCityAnswer = new javax.swing.JTextField();
        pnlProvinceRegionAnswer = new javax.swing.JPanel();
        lblRequestProvinceRegion = new javax.swing.JLabel();
        txtProvinceRegionAnswer = new javax.swing.JTextField();
        pnlQuizButtonArea = new javax.swing.JPanel();
        pnlQuizButtons = new javax.swing.JPanel();
        pnlSubmitButton = new javax.swing.JPanel();
        lblSubmitButton = new javax.swing.JLabel();
        pnlQuizOverButtons = new javax.swing.JPanel();
        pnlQuizReturnToMainMenuButton = new javax.swing.JPanel();
        lblReturnToMainMenuButton = new javax.swing.JLabel();
        pnlAfterAnswerButtons = new javax.swing.JPanel();
        pnlNextQuestionButton = new javax.swing.JPanel();
        lblNextQuestionButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackground.setLayout(new java.awt.CardLayout());

        pnlMainMenu.setBackground(new java.awt.Color(255, 255, 255));
        pnlMainMenu.setMinimumSize(new java.awt.Dimension(1000, 600));
        pnlMainMenu.setPreferredSize(new java.awt.Dimension(1000, 600));

        pnlMainMenuTop.setBackground(new java.awt.Color(153, 0, 51));

        pnlMainMenuTitle.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        pnlMainMenuTitle.setForeground(new java.awt.Color(255, 255, 255));
        pnlMainMenuTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlMainMenuTitle.setText("Canada Provincial Catalog");

        javax.swing.GroupLayout pnlMainMenuTopLayout = new javax.swing.GroupLayout(pnlMainMenuTop);
        pnlMainMenuTop.setLayout(pnlMainMenuTopLayout);
        pnlMainMenuTopLayout.setHorizontalGroup(
            pnlMainMenuTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainMenuTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)
        );
        pnlMainMenuTopLayout.setVerticalGroup(
            pnlMainMenuTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainMenuTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );

        pnlMainMenuBottom.setBackground(new java.awt.Color(204, 0, 51));
        pnlMainMenuBottom.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                pnlMainMenuBottomComponentAdded(evt);
            }
        });

        pnlMainMenuStart.setBackground(new java.awt.Color(255, 255, 255));
        pnlMainMenuStart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lblMainMenuStart.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblMainMenuStart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMainMenuStart.setText("Start");
        lblMainMenuStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMainMenuStartMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlMainMenuStartLayout = new javax.swing.GroupLayout(pnlMainMenuStart);
        pnlMainMenuStart.setLayout(pnlMainMenuStartLayout);
        pnlMainMenuStartLayout.setHorizontalGroup(
            pnlMainMenuStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMainMenuStart, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );
        pnlMainMenuStartLayout.setVerticalGroup(
            pnlMainMenuStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMainMenuStart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );

        pnlMainMenuQuiz.setBackground(new java.awt.Color(255, 255, 255));
        pnlMainMenuQuiz.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lblMainMenuQuiz.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblMainMenuQuiz.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMainMenuQuiz.setText("Quiz");
        lblMainMenuQuiz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMainMenuQuizMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlMainMenuQuizLayout = new javax.swing.GroupLayout(pnlMainMenuQuiz);
        pnlMainMenuQuiz.setLayout(pnlMainMenuQuizLayout);
        pnlMainMenuQuizLayout.setHorizontalGroup(
            pnlMainMenuQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainMenuQuizLayout.createSequentialGroup()
                .addComponent(lblMainMenuQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlMainMenuQuizLayout.setVerticalGroup(
            pnlMainMenuQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMainMenuQuiz, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlMainMenuBottomLayout = new javax.swing.GroupLayout(pnlMainMenuBottom);
        pnlMainMenuBottom.setLayout(pnlMainMenuBottomLayout);
        pnlMainMenuBottomLayout.setHorizontalGroup(
            pnlMainMenuBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainMenuBottomLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlMainMenuBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMainMenuQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMainMenuStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(353, 353, 353))
        );
        pnlMainMenuBottomLayout.setVerticalGroup(
            pnlMainMenuBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainMenuBottomLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(pnlMainMenuStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(pnlMainMenuQuiz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMainMenuLayout = new javax.swing.GroupLayout(pnlMainMenu);
        pnlMainMenu.setLayout(pnlMainMenuLayout);
        pnlMainMenuLayout.setHorizontalGroup(
            pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainMenuTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMainMenuBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMainMenuLayout.setVerticalGroup(
            pnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainMenuLayout.createSequentialGroup()
                .addComponent(pnlMainMenuTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMainMenuBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBackground.add(pnlMainMenu, "card2");

        pnlProvinceList.setBackground(new java.awt.Color(153, 255, 153));
        pnlProvinceList.setMinimumSize(new java.awt.Dimension(1000, 600));
        pnlProvinceList.setLayout(new java.awt.BorderLayout());

        pnlProvinceListTop.setBackground(new java.awt.Color(148, 220, 220));

        lblProvinceListTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblProvinceListTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblProvinceListTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProvinceListTitle.setText("Provinces and Territories");

        pnlProvinceListMainMenuButton.setBackground(new java.awt.Color(255, 255, 255));
        pnlProvinceListMainMenuButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlProvinceListMainMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlProvinceListMainMenuButtonMouseClicked(evt);
            }
        });

        lblProvinceListMainMenuButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblProvinceListMainMenuButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProvinceListMainMenuButton.setText("Main Menu");

        javax.swing.GroupLayout pnlProvinceListMainMenuButtonLayout = new javax.swing.GroupLayout(pnlProvinceListMainMenuButton);
        pnlProvinceListMainMenuButton.setLayout(pnlProvinceListMainMenuButtonLayout);
        pnlProvinceListMainMenuButtonLayout.setHorizontalGroup(
            pnlProvinceListMainMenuButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceListMainMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
        );
        pnlProvinceListMainMenuButtonLayout.setVerticalGroup(
            pnlProvinceListMainMenuButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceListMainMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        pnlProvinceListQuizStatus.setBackground(new java.awt.Color(107, 164, 164));

        lblProvinceListQuizStatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblProvinceListQuizStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblProvinceListQuizStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProvinceListQuizStatus.setText("Quiz Status: Locked");

        javax.swing.GroupLayout pnlProvinceListQuizStatusLayout = new javax.swing.GroupLayout(pnlProvinceListQuizStatus);
        pnlProvinceListQuizStatus.setLayout(pnlProvinceListQuizStatusLayout);
        pnlProvinceListQuizStatusLayout.setHorizontalGroup(
            pnlProvinceListQuizStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProvinceListQuizStatusLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblProvinceListQuizStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlProvinceListQuizStatusLayout.setVerticalGroup(
            pnlProvinceListQuizStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceListQuizStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlProvinceListTopLayout = new javax.swing.GroupLayout(pnlProvinceListTop);
        pnlProvinceListTop.setLayout(pnlProvinceListTopLayout);
        pnlProvinceListTopLayout.setHorizontalGroup(
            pnlProvinceListTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProvinceListTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlProvinceListMainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(lblProvinceListTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(pnlProvinceListQuizStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlProvinceListTopLayout.setVerticalGroup(
            pnlProvinceListTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceListTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
            .addGroup(pnlProvinceListTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlProvinceListMainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlProvinceListTopLayout.createSequentialGroup()
                .addComponent(pnlProvinceListQuizStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlProvinceList.add(pnlProvinceListTop, java.awt.BorderLayout.PAGE_START);

        pnlProvinceListBottom.setBackground(new java.awt.Color(255, 204, 153));
        pnlProvinceListBottom.setMinimumSize(new java.awt.Dimension(110, 310));
        pnlProvinceListBottom.setPreferredSize(new java.awt.Dimension(110, 310));

        pnlSelectAlberta.setMinimumSize(new java.awt.Dimension(235, 100));
        pnlSelectAlberta.setPreferredSize(new java.awt.Dimension(235, 100));
        pnlSelectAlberta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSelectAlbertaMouseClicked(evt);
            }
        });
        pnlSelectAlberta.setLayout(new javax.swing.OverlayLayout(pnlSelectAlberta));

        lblSelectAlberta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSelectAlberta.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectAlberta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSelectAlberta.setText("Alberta");
        pnlSelectAlberta.add(lblSelectAlberta);

        lblSelectAlbertaImage.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectAlbertaImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selectionMenu/Alberta.png"))); // NOI18N
        pnlSelectAlberta.add(lblSelectAlbertaImage);

        pnlProvinceListBottom.add(pnlSelectAlberta);

        pnlSelectBritishColombia.setBackground(new java.awt.Color(204, 204, 255));
        pnlSelectBritishColombia.setMinimumSize(new java.awt.Dimension(235, 100));
        pnlSelectBritishColombia.setPreferredSize(new java.awt.Dimension(235, 100));
        pnlSelectBritishColombia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSelectBritishColombiaMouseClicked(evt);
            }
        });
        pnlSelectBritishColombia.setLayout(new javax.swing.OverlayLayout(pnlSelectBritishColombia));

        lblSelectBritishColombia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSelectBritishColombia.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectBritishColombia.setText("British Colombia");
        pnlSelectBritishColombia.add(lblSelectBritishColombia);

        lblSelectBritishColombiaImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selectionMenu/British Colombia.jpg"))); // NOI18N
        pnlSelectBritishColombia.add(lblSelectBritishColombiaImage);

        pnlProvinceListBottom.add(pnlSelectBritishColombia);

        pnlSelectManitoba.setBackground(new java.awt.Color(204, 204, 255));
        pnlSelectManitoba.setMinimumSize(new java.awt.Dimension(235, 100));
        pnlSelectManitoba.setPreferredSize(new java.awt.Dimension(235, 100));
        pnlSelectManitoba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSelectManitobaMouseClicked(evt);
            }
        });
        pnlSelectManitoba.setLayout(new javax.swing.OverlayLayout(pnlSelectManitoba));

        lblSelectManitoba.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSelectManitoba.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectManitoba.setText("Manitoba");
        pnlSelectManitoba.add(lblSelectManitoba);

        lblSelectManitobaImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selectionMenu/Manitoba.jpg"))); // NOI18N
        pnlSelectManitoba.add(lblSelectManitobaImage);

        pnlProvinceListBottom.add(pnlSelectManitoba);

        pnlSelectNewBrunswick.setBackground(new java.awt.Color(204, 204, 255));
        pnlSelectNewBrunswick.setMinimumSize(new java.awt.Dimension(235, 100));
        pnlSelectNewBrunswick.setPreferredSize(new java.awt.Dimension(235, 100));
        pnlSelectNewBrunswick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSelectNewBrunswickMouseClicked(evt);
            }
        });
        pnlSelectNewBrunswick.setLayout(new javax.swing.OverlayLayout(pnlSelectNewBrunswick));

        lblSelectNewBrunswick.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSelectNewBrunswick.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectNewBrunswick.setText("New Brunswick");
        pnlSelectNewBrunswick.add(lblSelectNewBrunswick);

        lblSelectNewBrunswickImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selectionMenu/New Brunswick.jpg"))); // NOI18N
        pnlSelectNewBrunswick.add(lblSelectNewBrunswickImage);

        pnlProvinceListBottom.add(pnlSelectNewBrunswick);

        pnlSelectNewfoundlandAndLabrador.setBackground(new java.awt.Color(204, 204, 255));
        pnlSelectNewfoundlandAndLabrador.setMinimumSize(new java.awt.Dimension(235, 100));
        pnlSelectNewfoundlandAndLabrador.setPreferredSize(new java.awt.Dimension(235, 100));
        pnlSelectNewfoundlandAndLabrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSelectNewfoundlandAndLabradorMouseClicked(evt);
            }
        });
        pnlSelectNewfoundlandAndLabrador.setLayout(new javax.swing.OverlayLayout(pnlSelectNewfoundlandAndLabrador));

        lblSelectNewfoundlandAndLabrador.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSelectNewfoundlandAndLabrador.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectNewfoundlandAndLabrador.setText("Newfoundland and Labrador");
        pnlSelectNewfoundlandAndLabrador.add(lblSelectNewfoundlandAndLabrador);

        lblSelectNewfoundlandAndLabradorImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selectionMenu/Newfoundland and Labrador.jpg"))); // NOI18N
        pnlSelectNewfoundlandAndLabrador.add(lblSelectNewfoundlandAndLabradorImage);

        pnlProvinceListBottom.add(pnlSelectNewfoundlandAndLabrador);

        pnlSelectNorthwestTerritories.setBackground(new java.awt.Color(204, 204, 255));
        pnlSelectNorthwestTerritories.setMinimumSize(new java.awt.Dimension(235, 100));
        pnlSelectNorthwestTerritories.setPreferredSize(new java.awt.Dimension(235, 100));
        pnlSelectNorthwestTerritories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSelectNorthwestTerritoriesMouseClicked(evt);
            }
        });
        pnlSelectNorthwestTerritories.setLayout(new javax.swing.OverlayLayout(pnlSelectNorthwestTerritories));

        lblSelectNorthwestTerritories.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSelectNorthwestTerritories.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectNorthwestTerritories.setText("Northwest Territories");
        pnlSelectNorthwestTerritories.add(lblSelectNorthwestTerritories);

        lblSelectNorthwestTerritoriesImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selectionMenu/Northwest Territories.jpg"))); // NOI18N
        pnlSelectNorthwestTerritories.add(lblSelectNorthwestTerritoriesImage);

        pnlProvinceListBottom.add(pnlSelectNorthwestTerritories);

        pnlSelectNovaScotia.setBackground(new java.awt.Color(204, 204, 255));
        pnlSelectNovaScotia.setMinimumSize(new java.awt.Dimension(235, 100));
        pnlSelectNovaScotia.setPreferredSize(new java.awt.Dimension(235, 100));
        pnlSelectNovaScotia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSelectNovaScotiaMouseClicked(evt);
            }
        });
        pnlSelectNovaScotia.setLayout(new javax.swing.OverlayLayout(pnlSelectNovaScotia));

        lblSelectNovaScotia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSelectNovaScotia.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectNovaScotia.setText("Nova Scotia");
        pnlSelectNovaScotia.add(lblSelectNovaScotia);

        lblSelectNovaScotiaImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selectionMenu/Nova Scotia.jpg"))); // NOI18N
        pnlSelectNovaScotia.add(lblSelectNovaScotiaImage);

        pnlProvinceListBottom.add(pnlSelectNovaScotia);

        pnlSelectNunavut.setBackground(new java.awt.Color(204, 204, 255));
        pnlSelectNunavut.setMinimumSize(new java.awt.Dimension(235, 100));
        pnlSelectNunavut.setPreferredSize(new java.awt.Dimension(235, 100));
        pnlSelectNunavut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSelectNunavutMouseClicked(evt);
            }
        });
        pnlSelectNunavut.setLayout(new javax.swing.OverlayLayout(pnlSelectNunavut));

        lblSelectNunavut.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSelectNunavut.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectNunavut.setText("Nunavut");
        pnlSelectNunavut.add(lblSelectNunavut);

        lblSelectNunavutImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selectionMenu/Nunavut.jpg"))); // NOI18N
        pnlSelectNunavut.add(lblSelectNunavutImage);

        pnlProvinceListBottom.add(pnlSelectNunavut);

        pnlSelectOntario.setBackground(new java.awt.Color(204, 204, 255));
        pnlSelectOntario.setMinimumSize(new java.awt.Dimension(235, 100));
        pnlSelectOntario.setPreferredSize(new java.awt.Dimension(235, 100));
        pnlSelectOntario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSelectOntarioMouseClicked(evt);
            }
        });
        pnlSelectOntario.setLayout(new javax.swing.OverlayLayout(pnlSelectOntario));

        lblSelectOntario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSelectOntario.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectOntario.setText("Ontario");
        pnlSelectOntario.add(lblSelectOntario);

        lblSelectOntarioImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selectionMenu/Ontario.jpg"))); // NOI18N
        pnlSelectOntario.add(lblSelectOntarioImage);

        pnlProvinceListBottom.add(pnlSelectOntario);

        pnlSelectPrinceEdwardIsland.setBackground(new java.awt.Color(204, 204, 255));
        pnlSelectPrinceEdwardIsland.setMinimumSize(new java.awt.Dimension(235, 100));
        pnlSelectPrinceEdwardIsland.setPreferredSize(new java.awt.Dimension(235, 100));
        pnlSelectPrinceEdwardIsland.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSelectPrinceEdwardIslandMouseClicked(evt);
            }
        });
        pnlSelectPrinceEdwardIsland.setLayout(new javax.swing.OverlayLayout(pnlSelectPrinceEdwardIsland));

        lblSelectPrinceEdwardIsland.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSelectPrinceEdwardIsland.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectPrinceEdwardIsland.setText("Prince Edward Island");
        pnlSelectPrinceEdwardIsland.add(lblSelectPrinceEdwardIsland);

        lblSelectPrinceEdwardIslandImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selectionMenu/Prince Edward Island.jpg"))); // NOI18N
        pnlSelectPrinceEdwardIsland.add(lblSelectPrinceEdwardIslandImage);

        pnlProvinceListBottom.add(pnlSelectPrinceEdwardIsland);

        pnlSelectQuebec.setBackground(new java.awt.Color(204, 204, 255));
        pnlSelectQuebec.setMinimumSize(new java.awt.Dimension(235, 100));
        pnlSelectQuebec.setPreferredSize(new java.awt.Dimension(235, 100));
        pnlSelectQuebec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSelectQuebecMouseClicked(evt);
            }
        });
        pnlSelectQuebec.setLayout(new javax.swing.OverlayLayout(pnlSelectQuebec));

        lblSelectQuebec.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSelectQuebec.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectQuebec.setText("Quebec");
        pnlSelectQuebec.add(lblSelectQuebec);

        lblSelectQuebecImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selectionMenu/Quebec.jpg"))); // NOI18N
        pnlSelectQuebec.add(lblSelectQuebecImage);

        pnlProvinceListBottom.add(pnlSelectQuebec);

        pnlSelectSaskatchewan.setBackground(new java.awt.Color(204, 204, 255));
        pnlSelectSaskatchewan.setMinimumSize(new java.awt.Dimension(235, 100));
        pnlSelectSaskatchewan.setPreferredSize(new java.awt.Dimension(235, 100));
        pnlSelectSaskatchewan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSelectSaskatchewanMouseClicked(evt);
            }
        });
        pnlSelectSaskatchewan.setLayout(new javax.swing.OverlayLayout(pnlSelectSaskatchewan));

        lblSelectSaskatchewan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSelectSaskatchewan.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectSaskatchewan.setText("Saskatchewan");
        pnlSelectSaskatchewan.add(lblSelectSaskatchewan);

        lblSelectSaskatchewanImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selectionMenu/Saskatchewan.png"))); // NOI18N
        pnlSelectSaskatchewan.add(lblSelectSaskatchewanImage);

        pnlProvinceListBottom.add(pnlSelectSaskatchewan);

        pnlSelectYukon.setBackground(new java.awt.Color(204, 204, 255));
        pnlSelectYukon.setMinimumSize(new java.awt.Dimension(235, 100));
        pnlSelectYukon.setPreferredSize(new java.awt.Dimension(235, 100));
        pnlSelectYukon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSelectYukonMouseClicked(evt);
            }
        });
        pnlSelectYukon.setLayout(new javax.swing.OverlayLayout(pnlSelectYukon));

        lblSelectYukon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSelectYukon.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectYukon.setText("Yukon");
        pnlSelectYukon.add(lblSelectYukon);

        lblSelectYukonImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/selectionMenu/Yukon.jpg"))); // NOI18N
        pnlSelectYukon.add(lblSelectYukonImage);

        pnlProvinceListBottom.add(pnlSelectYukon);

        pnlProvinceList.add(pnlProvinceListBottom, java.awt.BorderLayout.CENTER);

        pnlBackground.add(pnlProvinceList, "card3");

        pnlProvinceDataPage.setBackground(new java.awt.Color(255, 204, 204));

        pnlProvinceDataMainMenuButton.setBackground(new java.awt.Color(255, 255, 255));
        pnlProvinceDataMainMenuButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlProvinceDataMainMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlProvinceDataMainMenuButtonMouseClicked(evt);
            }
        });

        lblProvinceDataMainMenuButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblProvinceDataMainMenuButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProvinceDataMainMenuButton.setText("Main Menu");

        javax.swing.GroupLayout pnlProvinceDataMainMenuButtonLayout = new javax.swing.GroupLayout(pnlProvinceDataMainMenuButton);
        pnlProvinceDataMainMenuButton.setLayout(pnlProvinceDataMainMenuButtonLayout);
        pnlProvinceDataMainMenuButtonLayout.setHorizontalGroup(
            pnlProvinceDataMainMenuButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataMainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlProvinceDataMainMenuButtonLayout.setVerticalGroup(
            pnlProvinceDataMainMenuButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataMainMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        pnlProvinceDataBackButton.setBackground(new java.awt.Color(255, 255, 255));
        pnlProvinceDataBackButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlProvinceDataBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlProvinceDataBackButtonMouseClicked(evt);
            }
        });

        lblProvinceDataBackButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblProvinceDataBackButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProvinceDataBackButton.setText("Back");

        javax.swing.GroupLayout pnlProvinceDataBackButtonLayout = new javax.swing.GroupLayout(pnlProvinceDataBackButton);
        pnlProvinceDataBackButton.setLayout(pnlProvinceDataBackButtonLayout);
        pnlProvinceDataBackButtonLayout.setHorizontalGroup(
            pnlProvinceDataBackButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataBackButton, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );
        pnlProvinceDataBackButtonLayout.setVerticalGroup(
            pnlProvinceDataBackButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataBackButton, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        pnlProvinceDataPageImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlProvinceDataPageImage.setPreferredSize(new java.awt.Dimension(420, 404));
        pnlProvinceDataPageImage.setLayout(new java.awt.CardLayout());

        lblProvinceDataAlbertaImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dataPage/Alberta.jpg"))); // NOI18N
        lblProvinceDataAlbertaImage.setText("jLabel26");
        lblProvinceDataAlbertaImage.setMaximumSize(new java.awt.Dimension(420, 404));
        lblProvinceDataAlbertaImage.setMinimumSize(new java.awt.Dimension(420, 404));
        lblProvinceDataAlbertaImage.setPreferredSize(new java.awt.Dimension(420, 404));

        javax.swing.GroupLayout pnlProvinceDataAlbertaImageLayout = new javax.swing.GroupLayout(pnlProvinceDataAlbertaImage);
        pnlProvinceDataAlbertaImage.setLayout(pnlProvinceDataAlbertaImageLayout);
        pnlProvinceDataAlbertaImageLayout.setHorizontalGroup(
            pnlProvinceDataAlbertaImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataAlbertaImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlProvinceDataAlbertaImageLayout.setVerticalGroup(
            pnlProvinceDataAlbertaImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataAlbertaImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlProvinceDataPageImage.add(pnlProvinceDataAlbertaImage, "card2");

        pnlProvinceDataBritishColombiaImage.setPreferredSize(new java.awt.Dimension(420, 404));

        lblProvinceDataBritishColombiaImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dataPage/British Colombia.jpg"))); // NOI18N
        lblProvinceDataBritishColombiaImage.setText("jLabel27");
        lblProvinceDataBritishColombiaImage.setMaximumSize(new java.awt.Dimension(420, 404));
        lblProvinceDataBritishColombiaImage.setMinimumSize(new java.awt.Dimension(420, 404));
        lblProvinceDataBritishColombiaImage.setPreferredSize(new java.awt.Dimension(420, 404));

        javax.swing.GroupLayout pnlProvinceDataBritishColombiaImageLayout = new javax.swing.GroupLayout(pnlProvinceDataBritishColombiaImage);
        pnlProvinceDataBritishColombiaImage.setLayout(pnlProvinceDataBritishColombiaImageLayout);
        pnlProvinceDataBritishColombiaImageLayout.setHorizontalGroup(
            pnlProvinceDataBritishColombiaImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataBritishColombiaImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlProvinceDataBritishColombiaImageLayout.setVerticalGroup(
            pnlProvinceDataBritishColombiaImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataBritishColombiaImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlProvinceDataPageImage.add(pnlProvinceDataBritishColombiaImage, "card3");

        lblProvinceDataManitobaImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dataPage/Manitoba.jpg"))); // NOI18N
        lblProvinceDataManitobaImage.setText("Manitoba");
        lblProvinceDataManitobaImage.setMaximumSize(new java.awt.Dimension(420, 404));
        lblProvinceDataManitobaImage.setMinimumSize(new java.awt.Dimension(420, 404));

        javax.swing.GroupLayout pnlProvinceDataManitobaImageLayout = new javax.swing.GroupLayout(pnlProvinceDataManitobaImage);
        pnlProvinceDataManitobaImage.setLayout(pnlProvinceDataManitobaImageLayout);
        pnlProvinceDataManitobaImageLayout.setHorizontalGroup(
            pnlProvinceDataManitobaImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataManitobaImage, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        pnlProvinceDataManitobaImageLayout.setVerticalGroup(
            pnlProvinceDataManitobaImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataManitobaImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlProvinceDataPageImage.add(pnlProvinceDataManitobaImage, "card4");

        lblProvinceDataNewBrunswickImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dataPage/New Brunswick.jpg"))); // NOI18N
        lblProvinceDataNewBrunswickImage.setText("New Brunswick");
        lblProvinceDataNewBrunswickImage.setMaximumSize(new java.awt.Dimension(420, 404));
        lblProvinceDataNewBrunswickImage.setMinimumSize(new java.awt.Dimension(420, 404));

        javax.swing.GroupLayout pnlProvinceDataNewBrunswickImageLayout = new javax.swing.GroupLayout(pnlProvinceDataNewBrunswickImage);
        pnlProvinceDataNewBrunswickImage.setLayout(pnlProvinceDataNewBrunswickImageLayout);
        pnlProvinceDataNewBrunswickImageLayout.setHorizontalGroup(
            pnlProvinceDataNewBrunswickImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataNewBrunswickImage, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        pnlProvinceDataNewBrunswickImageLayout.setVerticalGroup(
            pnlProvinceDataNewBrunswickImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataNewBrunswickImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlProvinceDataPageImage.add(pnlProvinceDataNewBrunswickImage, "card5");

        lblProvinceDataNewfoundlandAndLabradorImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dataPage/Newfoundland and Labrador.jpg"))); // NOI18N
        lblProvinceDataNewfoundlandAndLabradorImage.setText("Newfoundland and Labrador");
        lblProvinceDataNewfoundlandAndLabradorImage.setMaximumSize(new java.awt.Dimension(420, 404));
        lblProvinceDataNewfoundlandAndLabradorImage.setMinimumSize(new java.awt.Dimension(420, 404));

        javax.swing.GroupLayout pnlProvinceDataNewfoundlandAndLabradorImageLayout = new javax.swing.GroupLayout(pnlProvinceDataNewfoundlandAndLabradorImage);
        pnlProvinceDataNewfoundlandAndLabradorImage.setLayout(pnlProvinceDataNewfoundlandAndLabradorImageLayout);
        pnlProvinceDataNewfoundlandAndLabradorImageLayout.setHorizontalGroup(
            pnlProvinceDataNewfoundlandAndLabradorImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataNewfoundlandAndLabradorImage, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        pnlProvinceDataNewfoundlandAndLabradorImageLayout.setVerticalGroup(
            pnlProvinceDataNewfoundlandAndLabradorImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataNewfoundlandAndLabradorImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlProvinceDataPageImage.add(pnlProvinceDataNewfoundlandAndLabradorImage, "card6");

        lblProvinceDataNorthwestTerritoriesImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dataPage/Northwest Territories.jpg"))); // NOI18N
        lblProvinceDataNorthwestTerritoriesImage.setText("Northwest Territories");
        lblProvinceDataNorthwestTerritoriesImage.setMaximumSize(new java.awt.Dimension(420, 404));
        lblProvinceDataNorthwestTerritoriesImage.setMinimumSize(new java.awt.Dimension(420, 404));

        javax.swing.GroupLayout pnlProvinceDataNorthwestTerritoriesImageLayout = new javax.swing.GroupLayout(pnlProvinceDataNorthwestTerritoriesImage);
        pnlProvinceDataNorthwestTerritoriesImage.setLayout(pnlProvinceDataNorthwestTerritoriesImageLayout);
        pnlProvinceDataNorthwestTerritoriesImageLayout.setHorizontalGroup(
            pnlProvinceDataNorthwestTerritoriesImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataNorthwestTerritoriesImage, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        pnlProvinceDataNorthwestTerritoriesImageLayout.setVerticalGroup(
            pnlProvinceDataNorthwestTerritoriesImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataNorthwestTerritoriesImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlProvinceDataPageImage.add(pnlProvinceDataNorthwestTerritoriesImage, "card7");

        lblProvinceDataNovaScotiaImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dataPage/Nova Scotia.jpg"))); // NOI18N
        lblProvinceDataNovaScotiaImage.setText("Nova Scotia");
        lblProvinceDataNovaScotiaImage.setMaximumSize(new java.awt.Dimension(420, 404));
        lblProvinceDataNovaScotiaImage.setMinimumSize(new java.awt.Dimension(420, 404));

        javax.swing.GroupLayout pnlProvinceDataNovaScotiaImageLayout = new javax.swing.GroupLayout(pnlProvinceDataNovaScotiaImage);
        pnlProvinceDataNovaScotiaImage.setLayout(pnlProvinceDataNovaScotiaImageLayout);
        pnlProvinceDataNovaScotiaImageLayout.setHorizontalGroup(
            pnlProvinceDataNovaScotiaImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataNovaScotiaImage, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        pnlProvinceDataNovaScotiaImageLayout.setVerticalGroup(
            pnlProvinceDataNovaScotiaImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataNovaScotiaImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlProvinceDataPageImage.add(pnlProvinceDataNovaScotiaImage, "card8");

        lblProvinceDataNunavutImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dataPage/Nunavut.jpg"))); // NOI18N
        lblProvinceDataNunavutImage.setText("Nunavut");
        lblProvinceDataNunavutImage.setMaximumSize(new java.awt.Dimension(420, 404));
        lblProvinceDataNunavutImage.setMinimumSize(new java.awt.Dimension(420, 404));

        javax.swing.GroupLayout pnlProvinceDataNunavutImageLayout = new javax.swing.GroupLayout(pnlProvinceDataNunavutImage);
        pnlProvinceDataNunavutImage.setLayout(pnlProvinceDataNunavutImageLayout);
        pnlProvinceDataNunavutImageLayout.setHorizontalGroup(
            pnlProvinceDataNunavutImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataNunavutImage, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        pnlProvinceDataNunavutImageLayout.setVerticalGroup(
            pnlProvinceDataNunavutImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataNunavutImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlProvinceDataPageImage.add(pnlProvinceDataNunavutImage, "card9");

        lblProvinceDataOntarioImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dataPage/Ontario.jpg"))); // NOI18N
        lblProvinceDataOntarioImage.setText("Ontario");
        lblProvinceDataOntarioImage.setMaximumSize(new java.awt.Dimension(420, 404));
        lblProvinceDataOntarioImage.setMinimumSize(new java.awt.Dimension(420, 404));

        javax.swing.GroupLayout pnlProvinceDataOntarioImageLayout = new javax.swing.GroupLayout(pnlProvinceDataOntarioImage);
        pnlProvinceDataOntarioImage.setLayout(pnlProvinceDataOntarioImageLayout);
        pnlProvinceDataOntarioImageLayout.setHorizontalGroup(
            pnlProvinceDataOntarioImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataOntarioImage, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        pnlProvinceDataOntarioImageLayout.setVerticalGroup(
            pnlProvinceDataOntarioImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataOntarioImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlProvinceDataPageImage.add(pnlProvinceDataOntarioImage, "card10");

        lblProvinceDataPrinceEdwardIslandImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dataPage/Prince Edward Island.jpg"))); // NOI18N
        lblProvinceDataPrinceEdwardIslandImage.setText("Prince Edward Island");
        lblProvinceDataPrinceEdwardIslandImage.setMaximumSize(new java.awt.Dimension(420, 404));
        lblProvinceDataPrinceEdwardIslandImage.setMinimumSize(new java.awt.Dimension(420, 404));

        javax.swing.GroupLayout pnlProvinceDataPrinceEdwardIslandImageLayout = new javax.swing.GroupLayout(pnlProvinceDataPrinceEdwardIslandImage);
        pnlProvinceDataPrinceEdwardIslandImage.setLayout(pnlProvinceDataPrinceEdwardIslandImageLayout);
        pnlProvinceDataPrinceEdwardIslandImageLayout.setHorizontalGroup(
            pnlProvinceDataPrinceEdwardIslandImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataPrinceEdwardIslandImage, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        pnlProvinceDataPrinceEdwardIslandImageLayout.setVerticalGroup(
            pnlProvinceDataPrinceEdwardIslandImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataPrinceEdwardIslandImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlProvinceDataPageImage.add(pnlProvinceDataPrinceEdwardIslandImage, "card11");

        lblProvinceDataQuebecImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dataPage/Quebec.jpg"))); // NOI18N
        lblProvinceDataQuebecImage.setText("Quebec");
        lblProvinceDataQuebecImage.setMaximumSize(new java.awt.Dimension(420, 404));
        lblProvinceDataQuebecImage.setMinimumSize(new java.awt.Dimension(420, 404));

        javax.swing.GroupLayout pnlProvinceDataQuebecImageLayout = new javax.swing.GroupLayout(pnlProvinceDataQuebecImage);
        pnlProvinceDataQuebecImage.setLayout(pnlProvinceDataQuebecImageLayout);
        pnlProvinceDataQuebecImageLayout.setHorizontalGroup(
            pnlProvinceDataQuebecImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataQuebecImage, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        pnlProvinceDataQuebecImageLayout.setVerticalGroup(
            pnlProvinceDataQuebecImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataQuebecImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlProvinceDataPageImage.add(pnlProvinceDataQuebecImage, "card12");

        lblProvinceDataSaskatchewanImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dataPage/Saskatchewan.jpg"))); // NOI18N
        lblProvinceDataSaskatchewanImage.setText("Saskatchewan");
        lblProvinceDataSaskatchewanImage.setMaximumSize(new java.awt.Dimension(420, 404));
        lblProvinceDataSaskatchewanImage.setMinimumSize(new java.awt.Dimension(420, 404));

        javax.swing.GroupLayout pnlProvinceDataSaskatchewanImageLayout = new javax.swing.GroupLayout(pnlProvinceDataSaskatchewanImage);
        pnlProvinceDataSaskatchewanImage.setLayout(pnlProvinceDataSaskatchewanImageLayout);
        pnlProvinceDataSaskatchewanImageLayout.setHorizontalGroup(
            pnlProvinceDataSaskatchewanImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataSaskatchewanImage, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        pnlProvinceDataSaskatchewanImageLayout.setVerticalGroup(
            pnlProvinceDataSaskatchewanImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataSaskatchewanImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlProvinceDataPageImage.add(pnlProvinceDataSaskatchewanImage, "card13");

        lblProvinceDataYukonImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dataPage/Yukon.jpg"))); // NOI18N
        lblProvinceDataYukonImage.setText("Yukon");
        lblProvinceDataYukonImage.setMaximumSize(new java.awt.Dimension(420, 404));
        lblProvinceDataYukonImage.setMinimumSize(new java.awt.Dimension(420, 404));

        javax.swing.GroupLayout pnlProvinceDataYukonImageLayout = new javax.swing.GroupLayout(pnlProvinceDataYukonImage);
        pnlProvinceDataYukonImage.setLayout(pnlProvinceDataYukonImageLayout);
        pnlProvinceDataYukonImageLayout.setHorizontalGroup(
            pnlProvinceDataYukonImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataYukonImage, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        pnlProvinceDataYukonImageLayout.setVerticalGroup(
            pnlProvinceDataYukonImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataYukonImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlProvinceDataPageImage.add(pnlProvinceDataYukonImage, "card14");

        pnlProvinceDataPageInformation.setBackground(new java.awt.Color(124, 210, 210));
        pnlProvinceDataPageInformation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblProvinceDataPagePopulation.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblProvinceDataPagePopulation.setForeground(new java.awt.Color(255, 255, 255));
        lblProvinceDataPagePopulation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblProvinceDataPagePopulation.setText("Population");

        lblProvinceDataPageCapitalCity.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblProvinceDataPageCapitalCity.setForeground(new java.awt.Color(255, 255, 255));
        lblProvinceDataPageCapitalCity.setText("Capital City");

        lblProvinceDataPageClimate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblProvinceDataPageClimate.setForeground(new java.awt.Color(255, 255, 255));
        lblProvinceDataPageClimate.setText("Climate");

        lblProvinceDataPageFunFacts.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblProvinceDataPageFunFacts.setForeground(new java.awt.Color(255, 255, 255));
        lblProvinceDataPageFunFacts.setText("Fun Facts");
        lblProvinceDataPageFunFacts.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblProvinceDataFunFactsTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblProvinceDataFunFactsTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblProvinceDataFunFactsTitle.setText("Fun Facts:");

        javax.swing.GroupLayout pnlProvinceDataPageInformationLayout = new javax.swing.GroupLayout(pnlProvinceDataPageInformation);
        pnlProvinceDataPageInformation.setLayout(pnlProvinceDataPageInformationLayout);
        pnlProvinceDataPageInformationLayout.setHorizontalGroup(
            pnlProvinceDataPageInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProvinceDataPageInformationLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlProvinceDataPageInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProvinceDataFunFactsTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProvinceDataPageFunFacts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProvinceDataPagePopulation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProvinceDataPageCapitalCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                    .addComponent(lblProvinceDataPageClimate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlProvinceDataPageInformationLayout.setVerticalGroup(
            pnlProvinceDataPageInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProvinceDataPageInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProvinceDataPagePopulation, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProvinceDataPageCapitalCity, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProvinceDataPageClimate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProvinceDataFunFactsTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProvinceDataPageFunFacts, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlProvinceDataPageTitle.setBackground(new java.awt.Color(124, 210, 210));
        pnlProvinceDataPageTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblProvinceDataPageTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblProvinceDataPageTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblProvinceDataPageTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProvinceDataPageTitle.setText("Title of Province");

        javax.swing.GroupLayout pnlProvinceDataPageTitleLayout = new javax.swing.GroupLayout(pnlProvinceDataPageTitle);
        pnlProvinceDataPageTitle.setLayout(pnlProvinceDataPageTitleLayout);
        pnlProvinceDataPageTitleLayout.setHorizontalGroup(
            pnlProvinceDataPageTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataPageTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );
        pnlProvinceDataPageTitleLayout.setVerticalGroup(
            pnlProvinceDataPageTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblProvinceDataPageTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlProvinceDataPageLayout = new javax.swing.GroupLayout(pnlProvinceDataPage);
        pnlProvinceDataPage.setLayout(pnlProvinceDataPageLayout);
        pnlProvinceDataPageLayout.setHorizontalGroup(
            pnlProvinceDataPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProvinceDataPageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProvinceDataPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProvinceDataPageLayout.createSequentialGroup()
                        .addGroup(pnlProvinceDataPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlProvinceDataMainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlProvinceDataBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(101, 101, 101)
                        .addComponent(pnlProvinceDataPageTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(191, 191, 191))
                    .addGroup(pnlProvinceDataPageLayout.createSequentialGroup()
                        .addComponent(pnlProvinceDataPageImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlProvinceDataPageInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnlProvinceDataPageLayout.setVerticalGroup(
            pnlProvinceDataPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProvinceDataPageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProvinceDataPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlProvinceDataPageLayout.createSequentialGroup()
                        .addComponent(pnlProvinceDataMainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlProvinceDataBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlProvinceDataPageTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProvinceDataPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlProvinceDataPageInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlProvinceDataPageImage, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pnlBackground.add(pnlProvinceDataPage, "card5");

        pnlQuiz.setBackground(new java.awt.Color(255, 255, 255));

        lblQuizQuestion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblQuizQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuizQuestion.setText("Question 1/14: In total, how many provinces and territories are there in Canada?");
        lblQuizQuestion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlQuizMainMenuButton.setBackground(new java.awt.Color(255, 255, 255));
        pnlQuizMainMenuButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlQuizMainMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlQuizMainMenuButtonMouseClicked(evt);
            }
        });

        lblQuizMainMenuButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblQuizMainMenuButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuizMainMenuButton.setText("Main Menu");

        javax.swing.GroupLayout pnlQuizMainMenuButtonLayout = new javax.swing.GroupLayout(pnlQuizMainMenuButton);
        pnlQuizMainMenuButton.setLayout(pnlQuizMainMenuButtonLayout);
        pnlQuizMainMenuButtonLayout.setHorizontalGroup(
            pnlQuizMainMenuButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
            .addGroup(pnlQuizMainMenuButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblQuizMainMenuButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
        );
        pnlQuizMainMenuButtonLayout.setVerticalGroup(
            pnlQuizMainMenuButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 81, Short.MAX_VALUE)
            .addGroup(pnlQuizMainMenuButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblQuizMainMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
        );

        pnlQuizQuestionContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlQuestionBox.setBackground(new java.awt.Color(255, 255, 255));
        pnlQuestionBox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlQuestionBox.setLayout(new java.awt.CardLayout());

        pnlNumberOfProvincesAnswer.setBackground(new java.awt.Color(255, 102, 102));

        lblRequestNumberOfProvinces.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblRequestNumberOfProvinces.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRequestNumberOfProvinces.setText("Number of Provinces and Territories");

        txtNumberOfProvincesAnswer.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtNumberOfProvincesAnswer.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout pnlNumberOfProvincesAnswerLayout = new javax.swing.GroupLayout(pnlNumberOfProvincesAnswer);
        pnlNumberOfProvincesAnswer.setLayout(pnlNumberOfProvincesAnswerLayout);
        pnlNumberOfProvincesAnswerLayout.setHorizontalGroup(
            pnlNumberOfProvincesAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNumberOfProvincesAnswerLayout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(lblRequestNumberOfProvinces, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
            .addGroup(pnlNumberOfProvincesAnswerLayout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(txtNumberOfProvincesAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNumberOfProvincesAnswerLayout.setVerticalGroup(
            pnlNumberOfProvincesAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNumberOfProvincesAnswerLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblRequestNumberOfProvinces, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNumberOfProvincesAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        pnlQuestionBox.add(pnlNumberOfProvincesAnswer, "card4");

        pnlCapitalCityAnswer.setBackground(new java.awt.Color(204, 255, 153));

        lblRequestCapitalCity.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblRequestCapitalCity.setText("Capital City: (case-sensitive)");

        txtCapitalCityAnswer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlCapitalCityAnswerLayout = new javax.swing.GroupLayout(pnlCapitalCityAnswer);
        pnlCapitalCityAnswer.setLayout(pnlCapitalCityAnswerLayout);
        pnlCapitalCityAnswerLayout.setHorizontalGroup(
            pnlCapitalCityAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapitalCityAnswerLayout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addGroup(pnlCapitalCityAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCapitalCityAnswerLayout.createSequentialGroup()
                        .addComponent(txtCapitalCityAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCapitalCityAnswerLayout.createSequentialGroup()
                        .addComponent(lblRequestCapitalCity, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170))))
        );
        pnlCapitalCityAnswerLayout.setVerticalGroup(
            pnlCapitalCityAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCapitalCityAnswerLayout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(lblRequestCapitalCity)
                .addGap(18, 18, 18)
                .addComponent(txtCapitalCityAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );

        pnlQuestionBox.add(pnlCapitalCityAnswer, "card2");

        pnlProvinceRegionAnswer.setBackground(new java.awt.Color(204, 255, 255));

        lblRequestProvinceRegion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblRequestProvinceRegion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRequestProvinceRegion.setText("<html><center>Atlantic, Central, Prarie, West Coast or North: <br/>(case-sensitive)</center></html>");

        txtProvinceRegionAnswer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout pnlProvinceRegionAnswerLayout = new javax.swing.GroupLayout(pnlProvinceRegionAnswer);
        pnlProvinceRegionAnswer.setLayout(pnlProvinceRegionAnswerLayout);
        pnlProvinceRegionAnswerLayout.setHorizontalGroup(
            pnlProvinceRegionAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProvinceRegionAnswerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtProvinceRegionAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
            .addGroup(pnlProvinceRegionAnswerLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(lblRequestProvinceRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        pnlProvinceRegionAnswerLayout.setVerticalGroup(
            pnlProvinceRegionAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProvinceRegionAnswerLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(lblRequestProvinceRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtProvinceRegionAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        pnlQuestionBox.add(pnlProvinceRegionAnswer, "card3");

        pnlQuizButtonArea.setBackground(new java.awt.Color(255, 255, 255));
        pnlQuizButtonArea.setLayout(new java.awt.CardLayout());

        pnlQuizButtons.setBackground(new java.awt.Color(255, 255, 255));

        pnlSubmitButton.setBackground(new java.awt.Color(255, 255, 255));
        pnlSubmitButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblSubmitButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblSubmitButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubmitButton.setText("Submit");
        lblSubmitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSubmitButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlSubmitButtonLayout = new javax.swing.GroupLayout(pnlSubmitButton);
        pnlSubmitButton.setLayout(pnlSubmitButtonLayout);
        pnlSubmitButtonLayout.setHorizontalGroup(
            pnlSubmitButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
            .addGroup(pnlSubmitButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblSubmitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
        );
        pnlSubmitButtonLayout.setVerticalGroup(
            pnlSubmitButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
            .addGroup(pnlSubmitButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblSubmitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlQuizButtonsLayout = new javax.swing.GroupLayout(pnlQuizButtons);
        pnlQuizButtons.setLayout(pnlQuizButtonsLayout);
        pnlQuizButtonsLayout.setHorizontalGroup(
            pnlQuizButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlQuizButtonsLayout.createSequentialGroup()
                .addContainerGap(232, Short.MAX_VALUE)
                .addComponent(pnlSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229))
        );
        pnlQuizButtonsLayout.setVerticalGroup(
            pnlQuizButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuizButtonsLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(pnlSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pnlQuizButtonArea.add(pnlQuizButtons, "card2");

        pnlQuizOverButtons.setBackground(new java.awt.Color(255, 255, 255));

        pnlQuizReturnToMainMenuButton.setBackground(new java.awt.Color(255, 255, 255));
        pnlQuizReturnToMainMenuButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblReturnToMainMenuButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblReturnToMainMenuButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReturnToMainMenuButton.setText("Return to main menu");
        lblReturnToMainMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReturnToMainMenuButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlQuizReturnToMainMenuButtonLayout = new javax.swing.GroupLayout(pnlQuizReturnToMainMenuButton);
        pnlQuizReturnToMainMenuButton.setLayout(pnlQuizReturnToMainMenuButtonLayout);
        pnlQuizReturnToMainMenuButtonLayout.setHorizontalGroup(
            pnlQuizReturnToMainMenuButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblReturnToMainMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
        );
        pnlQuizReturnToMainMenuButtonLayout.setVerticalGroup(
            pnlQuizReturnToMainMenuButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblReturnToMainMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlQuizOverButtonsLayout = new javax.swing.GroupLayout(pnlQuizOverButtons);
        pnlQuizOverButtons.setLayout(pnlQuizOverButtonsLayout);
        pnlQuizOverButtonsLayout.setHorizontalGroup(
            pnlQuizOverButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlQuizOverButtonsLayout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(pnlQuizReturnToMainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
        );
        pnlQuizOverButtonsLayout.setVerticalGroup(
            pnlQuizOverButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuizOverButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlQuizReturnToMainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pnlQuizButtonArea.add(pnlQuizOverButtons, "card3");

        pnlAfterAnswerButtons.setBackground(new java.awt.Color(255, 255, 255));

        pnlNextQuestionButton.setBackground(new java.awt.Color(255, 255, 255));
        pnlNextQuestionButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNextQuestionButton.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblNextQuestionButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNextQuestionButton.setText("Next");
        lblNextQuestionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNextQuestionButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlNextQuestionButtonLayout = new javax.swing.GroupLayout(pnlNextQuestionButton);
        pnlNextQuestionButton.setLayout(pnlNextQuestionButtonLayout);
        pnlNextQuestionButtonLayout.setHorizontalGroup(
            pnlNextQuestionButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNextQuestionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
        );
        pnlNextQuestionButtonLayout.setVerticalGroup(
            pnlNextQuestionButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNextQuestionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlAfterAnswerButtonsLayout = new javax.swing.GroupLayout(pnlAfterAnswerButtons);
        pnlAfterAnswerButtons.setLayout(pnlAfterAnswerButtonsLayout);
        pnlAfterAnswerButtonsLayout.setHorizontalGroup(
            pnlAfterAnswerButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAfterAnswerButtonsLayout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addComponent(pnlNextQuestionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
        );
        pnlAfterAnswerButtonsLayout.setVerticalGroup(
            pnlAfterAnswerButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAfterAnswerButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlNextQuestionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pnlQuizButtonArea.add(pnlAfterAnswerButtons, "card4");

        javax.swing.GroupLayout pnlQuizQuestionContainerLayout = new javax.swing.GroupLayout(pnlQuizQuestionContainer);
        pnlQuizQuestionContainer.setLayout(pnlQuizQuestionContainerLayout);
        pnlQuizQuestionContainerLayout.setHorizontalGroup(
            pnlQuizQuestionContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlQuestionBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlQuizButtonArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlQuizQuestionContainerLayout.setVerticalGroup(
            pnlQuizQuestionContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuizQuestionContainerLayout.createSequentialGroup()
                .addComponent(pnlQuestionBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnlQuizButtonArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlQuizLayout = new javax.swing.GroupLayout(pnlQuiz);
        pnlQuiz.setLayout(pnlQuizLayout);
        pnlQuizLayout.setHorizontalGroup(
            pnlQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuizLayout.createSequentialGroup()
                .addComponent(pnlQuizMainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(pnlQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlQuizQuestionContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblQuizQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        pnlQuizLayout.setVerticalGroup(
            pnlQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuizLayout.createSequentialGroup()
                .addGroup(pnlQuizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlQuizMainMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlQuizLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblQuizQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlQuizQuestionContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlBackground.add(pnlQuiz, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void lblMainMenuStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMainMenuStartMouseClicked
        // TODO add your handling code here:
        this.pnlBackground.removeAll();
        this.pnlBackground.add(this.pnlProvinceList);
        backgroundRefresh();
    }//GEN-LAST:event_lblMainMenuStartMouseClicked

    private void pnlSelectAlbertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSelectAlbertaMouseClicked
        // Show information according to selected province
        this.showProvinceData("Alberta");
        this.pnlSelectAlberta.setBorder(BorderFactory.createLineBorder(Color.green, 3));
        blnProvincePageReadByUser[0] = true;
    }//GEN-LAST:event_pnlSelectAlbertaMouseClicked

    private void pnlSelectBritishColombiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSelectBritishColombiaMouseClicked
        this.showProvinceData("British Colombia");
        this.pnlSelectBritishColombia.setBorder(BorderFactory.createLineBorder(Color.green, 3));
        blnProvincePageReadByUser[1] = true;
    }//GEN-LAST:event_pnlSelectBritishColombiaMouseClicked

    private void pnlSelectManitobaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSelectManitobaMouseClicked
        this.showProvinceData("Manitoba");
        this.pnlSelectManitoba.setBorder(BorderFactory.createLineBorder(Color.green, 3));
        blnProvincePageReadByUser[2] = true;
    }//GEN-LAST:event_pnlSelectManitobaMouseClicked

    private void pnlSelectNewBrunswickMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSelectNewBrunswickMouseClicked
        this.showProvinceData("New Brunswick");
        this.pnlSelectNewBrunswick.setBorder(BorderFactory.createLineBorder(Color.green, 3));
        blnProvincePageReadByUser[3] = true;
    }//GEN-LAST:event_pnlSelectNewBrunswickMouseClicked

    private void pnlSelectNewfoundlandAndLabradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSelectNewfoundlandAndLabradorMouseClicked
        this.showProvinceData("Newfoundland and Labrador");
        this.pnlSelectNewfoundlandAndLabrador.setBorder(BorderFactory.createLineBorder(Color.green, 3));
        blnProvincePageReadByUser[4] = true;
    }//GEN-LAST:event_pnlSelectNewfoundlandAndLabradorMouseClicked

    private void pnlSelectNorthwestTerritoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSelectNorthwestTerritoriesMouseClicked
        this.showProvinceData("Northwest Territories");
        this.pnlSelectNorthwestTerritories.setBorder(BorderFactory.createLineBorder(Color.green, 3));
        blnProvincePageReadByUser[5] = true;
    }//GEN-LAST:event_pnlSelectNorthwestTerritoriesMouseClicked

    private void pnlSelectNovaScotiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSelectNovaScotiaMouseClicked
        this.showProvinceData("Nova Scotia");
        this.pnlSelectNovaScotia.setBorder(BorderFactory.createLineBorder(Color.green, 3));
        blnProvincePageReadByUser[6] = true;
    }//GEN-LAST:event_pnlSelectNovaScotiaMouseClicked

    private void pnlSelectNunavutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSelectNunavutMouseClicked
        this.showProvinceData("Nunavut");
        this.pnlSelectNunavut.setBorder(BorderFactory.createLineBorder(Color.green, 3));
        blnProvincePageReadByUser[7] = true;
    }//GEN-LAST:event_pnlSelectNunavutMouseClicked

    private void pnlSelectOntarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSelectOntarioMouseClicked
        this.showProvinceData("Ontario");
        this.pnlSelectOntario.setBorder(BorderFactory.createLineBorder(Color.green, 3));
        blnProvincePageReadByUser[8] = true;
    }//GEN-LAST:event_pnlSelectOntarioMouseClicked

    private void pnlSelectPrinceEdwardIslandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSelectPrinceEdwardIslandMouseClicked
        this.showProvinceData("Prince Edward Island");
        this.pnlSelectPrinceEdwardIsland.setBorder(BorderFactory.createLineBorder(Color.green, 3));
        blnProvincePageReadByUser[9] = true;
    }//GEN-LAST:event_pnlSelectPrinceEdwardIslandMouseClicked

    private void pnlSelectQuebecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSelectQuebecMouseClicked
        this.showProvinceData("Quebec");
        this.pnlSelectQuebec.setBorder(BorderFactory.createLineBorder(Color.green, 3));
        blnProvincePageReadByUser[10] = true;
    }//GEN-LAST:event_pnlSelectQuebecMouseClicked

    private void pnlSelectSaskatchewanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSelectSaskatchewanMouseClicked
        this.showProvinceData("Saskatchewan");
        this.pnlSelectSaskatchewan.setBorder(BorderFactory.createLineBorder(Color.green, 3));
        blnProvincePageReadByUser[11] = true;
    }//GEN-LAST:event_pnlSelectSaskatchewanMouseClicked

    private void pnlSelectYukonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSelectYukonMouseClicked
        this.showProvinceData("Yukon");
        this.pnlSelectYukon.setBorder(BorderFactory.createLineBorder(Color.green, 3));
        blnProvincePageReadByUser[12] = true;
    }//GEN-LAST:event_pnlSelectYukonMouseClicked

    private void pnlProvinceDataMainMenuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlProvinceDataMainMenuButtonMouseClicked
        // Return to main menu page
        returnToMainMenu();
    }//GEN-LAST:event_pnlProvinceDataMainMenuButtonMouseClicked

    private void lblMainMenuQuizMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMainMenuQuizMouseClicked
        // Switch to quiz
        this.pnlBackground.removeAll();
        this.pnlBackground.add(this.pnlQuiz);
        intQuestionType = 0;
        backgroundRefresh();
    }//GEN-LAST:event_lblMainMenuQuizMouseClicked

    private void pnlQuizMainMenuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlQuizMainMenuButtonMouseClicked
        returnToMainMenu();
    }//GEN-LAST:event_pnlQuizMainMenuButtonMouseClicked

    private void pnlProvinceListMainMenuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlProvinceListMainMenuButtonMouseClicked
        returnToMainMenu();
    }//GEN-LAST:event_pnlProvinceListMainMenuButtonMouseClicked

    private void lblSubmitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSubmitButtonMouseClicked
        // Check if previous question is correct
        checkQuestion();
        
        // Print number of questions answered
        System.out.println(
            "Correct: " + intCorrectAnswers +
            " Incorrect: " + (intQuestionsAsked - intCorrectAnswers) +
            " Total: " + intQuestionsAsked);
        
        // Source: https://www.programiz.com/java-programming/examples/print-array
        for (boolean element: blnEncounteredProvince) {
            System.out.print(element + " ");
        }
        backgroundRefresh();
    }//GEN-LAST:event_lblSubmitButtonMouseClicked

    private void lblReturnToMainMenuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReturnToMainMenuButtonMouseClicked
        returnToMainMenu();
        resetQuiz();
        this.pnlQuizButtonArea.removeAll();
        this.pnlQuizButtonArea.add(this.pnlQuizButtons);
        this.pnlQuestionBox.removeAll();
        this.pnlQuestionBox.add(this.pnlNumberOfProvincesAnswer);
        this.lblQuizQuestion.setText("Question 1/14: In total, how many provinces and territories are there in Canada?");
    }//GEN-LAST:event_lblReturnToMainMenuButtonMouseClicked

    private void pnlProvinceDataBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlProvinceDataBackButtonMouseClicked
        this.pnlBackground.removeAll();
        this.pnlBackground.add(this.pnlProvinceList);
        
        // Unlocks quiz if all provinces have been viewed
        //Source: https://stackoverflow.com/questions/18631837/how-to-check-all-elements-of-a-boolean-array-are-true/18632446
        int i;
        for(i=0; i<13; i++) {
            if(blnProvincePageReadByUser[i] == false) {
                break;
            }
            else if (i == 12) {
                System.out.println("unlocked quiz");
                blnQuizUnlocked = true;
                this.lblProvinceListQuizStatus.setText("Quiz Unlocked");
            }
        }
        
        backgroundRefresh();
    }//GEN-LAST:event_pnlProvinceDataBackButtonMouseClicked

    private void lblNextQuestionButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextQuestionButtonMouseClicked
        // Display score or advance to next question depending on number of questions answered
        if(intQuestionsAsked < 14) {
            this.pnlQuizButtonArea.removeAll();
            this.pnlQuizButtonArea.add(this.pnlQuizButtons);
            showNewQuestion();
            checkEncountered();
        }
        else {
            this.pnlQuestionBox.removeAll();
            //this.pnlQuestionBox.add(this.jPanel1);
            this.lblQuizQuestion.setText("Your score is: " + intCorrectAnswers + "/" + intQuestionsAsked);
            this.pnlQuizButtonArea.removeAll();
            this.pnlQuizButtonArea.add(this.pnlQuizOverButtons);
            backgroundRefresh();
        }
        
    }//GEN-LAST:event_lblNextQuestionButtonMouseClicked

    private void pnlMainMenuBottomComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_pnlMainMenuBottomComponentAdded
        // Hide quiz at program start
        this.pnlMainMenuQuiz.setVisible(false);
    }//GEN-LAST:event_pnlMainMenuBottomComponentAdded
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(U4_A3_ProvincialCatalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(U4_A3_ProvincialCatalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(U4_A3_ProvincialCatalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(U4_A3_ProvincialCatalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new U4_A3_ProvincialCatalog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblMainMenuQuiz;
    private javax.swing.JLabel lblMainMenuStart;
    private javax.swing.JLabel lblNextQuestionButton;
    private javax.swing.JLabel lblProvinceDataAlbertaImage;
    private javax.swing.JLabel lblProvinceDataBackButton;
    private javax.swing.JLabel lblProvinceDataBritishColombiaImage;
    private javax.swing.JLabel lblProvinceDataFunFactsTitle;
    private javax.swing.JLabel lblProvinceDataMainMenuButton;
    private javax.swing.JLabel lblProvinceDataManitobaImage;
    private javax.swing.JLabel lblProvinceDataNewBrunswickImage;
    private javax.swing.JLabel lblProvinceDataNewfoundlandAndLabradorImage;
    private javax.swing.JLabel lblProvinceDataNorthwestTerritoriesImage;
    private javax.swing.JLabel lblProvinceDataNovaScotiaImage;
    private javax.swing.JLabel lblProvinceDataNunavutImage;
    private javax.swing.JLabel lblProvinceDataOntarioImage;
    private javax.swing.JLabel lblProvinceDataPageCapitalCity;
    private javax.swing.JLabel lblProvinceDataPageClimate;
    private javax.swing.JLabel lblProvinceDataPageFunFacts;
    private javax.swing.JLabel lblProvinceDataPagePopulation;
    private javax.swing.JLabel lblProvinceDataPageTitle;
    private javax.swing.JLabel lblProvinceDataPrinceEdwardIslandImage;
    private javax.swing.JLabel lblProvinceDataQuebecImage;
    private javax.swing.JLabel lblProvinceDataSaskatchewanImage;
    private javax.swing.JLabel lblProvinceDataYukonImage;
    private javax.swing.JLabel lblProvinceListMainMenuButton;
    private javax.swing.JLabel lblProvinceListQuizStatus;
    private javax.swing.JLabel lblProvinceListTitle;
    private javax.swing.JLabel lblQuizMainMenuButton;
    private javax.swing.JLabel lblQuizQuestion;
    private javax.swing.JLabel lblRequestCapitalCity;
    private javax.swing.JLabel lblRequestNumberOfProvinces;
    private javax.swing.JLabel lblRequestProvinceRegion;
    private javax.swing.JLabel lblReturnToMainMenuButton;
    private javax.swing.JLabel lblSelectAlberta;
    private javax.swing.JLabel lblSelectAlbertaImage;
    private javax.swing.JLabel lblSelectBritishColombia;
    private javax.swing.JLabel lblSelectBritishColombiaImage;
    private javax.swing.JLabel lblSelectManitoba;
    private javax.swing.JLabel lblSelectManitobaImage;
    private javax.swing.JLabel lblSelectNewBrunswick;
    private javax.swing.JLabel lblSelectNewBrunswickImage;
    private javax.swing.JLabel lblSelectNewfoundlandAndLabrador;
    private javax.swing.JLabel lblSelectNewfoundlandAndLabradorImage;
    private javax.swing.JLabel lblSelectNorthwestTerritories;
    private javax.swing.JLabel lblSelectNorthwestTerritoriesImage;
    private javax.swing.JLabel lblSelectNovaScotia;
    private javax.swing.JLabel lblSelectNovaScotiaImage;
    private javax.swing.JLabel lblSelectNunavut;
    private javax.swing.JLabel lblSelectNunavutImage;
    private javax.swing.JLabel lblSelectOntario;
    private javax.swing.JLabel lblSelectOntarioImage;
    private javax.swing.JLabel lblSelectPrinceEdwardIsland;
    private javax.swing.JLabel lblSelectPrinceEdwardIslandImage;
    private javax.swing.JLabel lblSelectQuebec;
    private javax.swing.JLabel lblSelectQuebecImage;
    private javax.swing.JLabel lblSelectSaskatchewan;
    private javax.swing.JLabel lblSelectSaskatchewanImage;
    private javax.swing.JLabel lblSelectYukon;
    private javax.swing.JLabel lblSelectYukonImage;
    private javax.swing.JLabel lblSubmitButton;
    private javax.swing.JPanel pnlAfterAnswerButtons;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlCapitalCityAnswer;
    private javax.swing.JPanel pnlMainMenu;
    private javax.swing.JPanel pnlMainMenuBottom;
    private javax.swing.JPanel pnlMainMenuQuiz;
    private javax.swing.JPanel pnlMainMenuStart;
    private javax.swing.JLabel pnlMainMenuTitle;
    private javax.swing.JPanel pnlMainMenuTop;
    private javax.swing.JPanel pnlNextQuestionButton;
    private javax.swing.JPanel pnlNumberOfProvincesAnswer;
    private javax.swing.JPanel pnlProvinceDataAlbertaImage;
    private javax.swing.JPanel pnlProvinceDataBackButton;
    private javax.swing.JPanel pnlProvinceDataBritishColombiaImage;
    private javax.swing.JPanel pnlProvinceDataMainMenuButton;
    private javax.swing.JPanel pnlProvinceDataManitobaImage;
    private javax.swing.JPanel pnlProvinceDataNewBrunswickImage;
    private javax.swing.JPanel pnlProvinceDataNewfoundlandAndLabradorImage;
    private javax.swing.JPanel pnlProvinceDataNorthwestTerritoriesImage;
    private javax.swing.JPanel pnlProvinceDataNovaScotiaImage;
    private javax.swing.JPanel pnlProvinceDataNunavutImage;
    private javax.swing.JPanel pnlProvinceDataOntarioImage;
    private javax.swing.JPanel pnlProvinceDataPage;
    private javax.swing.JPanel pnlProvinceDataPageImage;
    private javax.swing.JPanel pnlProvinceDataPageInformation;
    private javax.swing.JPanel pnlProvinceDataPageTitle;
    private javax.swing.JPanel pnlProvinceDataPrinceEdwardIslandImage;
    private javax.swing.JPanel pnlProvinceDataQuebecImage;
    private javax.swing.JPanel pnlProvinceDataSaskatchewanImage;
    private javax.swing.JPanel pnlProvinceDataYukonImage;
    private javax.swing.JPanel pnlProvinceList;
    private javax.swing.JPanel pnlProvinceListBottom;
    private javax.swing.JPanel pnlProvinceListMainMenuButton;
    private javax.swing.JPanel pnlProvinceListQuizStatus;
    private javax.swing.JPanel pnlProvinceListTop;
    private javax.swing.JPanel pnlProvinceRegionAnswer;
    private javax.swing.JPanel pnlQuestionBox;
    private javax.swing.JPanel pnlQuiz;
    private javax.swing.JPanel pnlQuizButtonArea;
    private javax.swing.JPanel pnlQuizButtons;
    private javax.swing.JPanel pnlQuizMainMenuButton;
    private javax.swing.JPanel pnlQuizOverButtons;
    private javax.swing.JPanel pnlQuizQuestionContainer;
    private javax.swing.JPanel pnlQuizReturnToMainMenuButton;
    private javax.swing.JPanel pnlSelectAlberta;
    private javax.swing.JPanel pnlSelectBritishColombia;
    private javax.swing.JPanel pnlSelectManitoba;
    private javax.swing.JPanel pnlSelectNewBrunswick;
    private javax.swing.JPanel pnlSelectNewfoundlandAndLabrador;
    private javax.swing.JPanel pnlSelectNorthwestTerritories;
    private javax.swing.JPanel pnlSelectNovaScotia;
    private javax.swing.JPanel pnlSelectNunavut;
    private javax.swing.JPanel pnlSelectOntario;
    private javax.swing.JPanel pnlSelectPrinceEdwardIsland;
    private javax.swing.JPanel pnlSelectQuebec;
    private javax.swing.JPanel pnlSelectSaskatchewan;
    private javax.swing.JPanel pnlSelectYukon;
    private javax.swing.JPanel pnlSubmitButton;
    private javax.swing.JTextField txtCapitalCityAnswer;
    private javax.swing.JTextField txtNumberOfProvincesAnswer;
    private javax.swing.JTextField txtProvinceRegionAnswer;
    // End of variables declaration//GEN-END:variables
}
