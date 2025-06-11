package gherkinexecutor.Feature_Bowling;
import java.util.*;
import org.example.*;
class FrameValues{
    String frame = "1";
    String roll1 = "-1";
    String roll2 = "-1";
    String roll3 = "-1";
    String score = "-1";
    String totalScore = "-1";
    public FrameValues() { }
    public FrameValues(
        String frame
        ,String roll1
        ,String roll2
        ,String roll3
        ,String score
        ,String totalScore
        ){
        this.frame = frame;
        this.roll1 = roll1;
        this.roll2 = roll2;
        this.roll3 = roll3;
        this.score = score;
        this.totalScore = totalScore;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        FrameValues _FrameValues = (FrameValues) o;
            boolean result = true;
         if (
             !this.frame.equals("?DNC?")
                && !_FrameValues.frame.equals("?DNC?"))
                if (! _FrameValues.frame.equals(this.frame)) result = false;
         if (
             !this.roll1.equals("?DNC?")
                && !_FrameValues.roll1.equals("?DNC?"))
                if (! _FrameValues.roll1.equals(this.roll1)) result = false;
         if (
             !this.roll2.equals("?DNC?")
                && !_FrameValues.roll2.equals("?DNC?"))
                if (! _FrameValues.roll2.equals(this.roll2)) result = false;
         if (
             !this.roll3.equals("?DNC?")
                && !_FrameValues.roll3.equals("?DNC?"))
                if (! _FrameValues.roll3.equals(this.roll3)) result = false;
         if (
             !this.score.equals("?DNC?")
                && !_FrameValues.score.equals("?DNC?"))
                if (! _FrameValues.score.equals(this.score)) result = false;
         if (
             !this.totalScore.equals("?DNC?")
                && !_FrameValues.totalScore.equals("?DNC?"))
                if (! _FrameValues.totalScore.equals(this.totalScore)) result = false;
             return result;  }
    public static class Builder {
        private String frame = "1";
        private String roll1 = "-1";
        private String roll2 = "-1";
        private String roll3 = "-1";
        private String score = "-1";
        private String totalScore = "-1";
        public Builder setFrame(String frame) {
            this.frame = frame;
            return this;
            }
        public Builder setRoll1(String roll1) {
            this.roll1 = roll1;
            return this;
            }
        public Builder setRoll2(String roll2) {
            this.roll2 = roll2;
            return this;
            }
        public Builder setRoll3(String roll3) {
            this.roll3 = roll3;
            return this;
            }
        public Builder setScore(String score) {
            this.score = score;
            return this;
            }
        public Builder setTotalScore(String totalScore) {
            this.totalScore = totalScore;
            return this;
            }
        public Builder  setCompare() {
            frame = "?DNC?";
            roll1 = "?DNC?";
            roll2 = "?DNC?";
            roll3 = "?DNC?";
            score = "?DNC?";
            totalScore = "?DNC?";
            return this;
            }
        public FrameValues build(){
             return new FrameValues(
                 frame
                 ,roll1
                 ,roll2
                 ,roll3
                 ,score
                 ,totalScore
                );   } 
        } 
        @Override
        public String toString() {
            return "FrameValues {"
             +"frame = " + frame + " "
             +"roll1 = " + roll1 + " "
             +"roll2 = " + roll2 + " "
             +"roll3 = " + roll3 + " "
             +"score = " + score + " "
             +"totalScore = " + totalScore + " "
             + "} " + "\n"; }

    public String toJson() {
        return " {"
         +""+"frame:" + "\"" + frame + "\""
         + ","         +""+"roll1:" + "\"" + roll1 + "\""
         + ","         +""+"roll2:" + "\"" + roll2 + "\""
         + ","         +""+"roll3:" + "\"" + roll3 + "\""
         + ","         +""+"score:" + "\"" + score + "\""
         + ","         +""+"totalScore:" + "\"" + totalScore + "\""
                + "} " ; }

        public static FrameValues fromJson(String json) {
              FrameValues instance = new FrameValues();

              	json = json.replaceAll("\\s", "");
                String[] keyValuePairs = json.replace("{", "").replace("}", "").split(",");

                // Iterate over the key-value pairs
                for (String pair : keyValuePairs) {
                    // Split each pair by the colon
                    String[] entry = pair.split(":");

                    // Remove the quotes from the key and value
                    String key = entry[0].replace("\"", "").trim();
                    String value = entry[1].replace("\"", "").trim();


          // Assign the value to the corresponding field
                    switch (key) {
              case "frame":
                  instance.frame = value;
                  break;
              case "roll1":
                  instance.roll1 = value;
                  break;
              case "roll2":
                  instance.roll2 = value;
                  break;
              case "roll3":
                  instance.roll3 = value;
                  break;
              case "score":
                  instance.score = value;
                  break;
              case "totalScore":
                  instance.totalScore = value;
                  break;
        				default:
        				    System.err.println("Invalid JSON element " + key);
                    }
                }
                return instance;
            }


             public static String listToJson(List<FrameValues> list) {
                 StringBuilder jsonBuilder = new StringBuilder();
                 jsonBuilder.append("[");

                 for (int i = 0; i < list.size(); i++) {
                     jsonBuilder.append(list.get(i).toJson());
                     if (i < list.size() - 1) {
                         jsonBuilder.append(",");
                     }
                 }

                 jsonBuilder.append("]");
                 return jsonBuilder.toString();
             }

             public static List<FrameValues> listFromJson(String json) {
                    List<FrameValues> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
            		json = json.replaceAll("\\[","").replaceAll("]","");
                    String[] jsonObjects = json.split("(?<=\\}),\\s*(?=\\{)");
                    for (String jsonObject : jsonObjects) {
                         list.add(FrameValues.fromJson(jsonObject));
                         }
                    return list;
                }

    FrameValuesInternal toFrameValuesInternal() {
        return new FrameValuesInternal(
         Integer.valueOf(frame)
        , new Roll(roll1)
        , new Roll(roll2)
        , new Roll(roll3)
        , new Score(score)
        , new Score(totalScore)
        ); }
    }
