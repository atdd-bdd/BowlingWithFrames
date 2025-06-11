package gherkinexecutor.Feature_Bowling;
import java.util.*;
import org.example.*;
//noinspection CanBeFinal
//noinspection UnusedImports
@SuppressWarnings({"unused", "EnhancedSwitchMigration", "ClassCanBeRecord", "NewClassNamingConvention", "RedundantSuppression"})
class FrameDisplay{
    String frame = "";
    String mark1 = "";
    String mark2 = "";
    String mark3 = "";
    String totalScore = "";
    public FrameDisplay() { }
    public FrameDisplay(
        String frame
        ,String mark1
        ,String mark2
        ,String mark3
        ,String totalScore
        ){
        this.frame = frame;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.totalScore = totalScore;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
             return false;
        FrameDisplay _FrameDisplay = (FrameDisplay) o;
            boolean result = true;
         if (
             !this.frame.equals("?DNC?")
                && !_FrameDisplay.frame.equals("?DNC?"))
                if (! _FrameDisplay.frame.equals(this.frame)) result = false;
         if (
             !this.mark1.equals("?DNC?")
                && !_FrameDisplay.mark1.equals("?DNC?"))
                if (! _FrameDisplay.mark1.equals(this.mark1)) result = false;
         if (
             !this.mark2.equals("?DNC?")
                && !_FrameDisplay.mark2.equals("?DNC?"))
                if (! _FrameDisplay.mark2.equals(this.mark2)) result = false;
         if (
             !this.mark3.equals("?DNC?")
                && !_FrameDisplay.mark3.equals("?DNC?"))
                if (! _FrameDisplay.mark3.equals(this.mark3)) result = false;
         if (
             !this.totalScore.equals("?DNC?")
                && !_FrameDisplay.totalScore.equals("?DNC?"))
                if (! _FrameDisplay.totalScore.equals(this.totalScore)) result = false;
             return result;  }
//noinspection CanBeFinal
//noinspection UnusedImports
@SuppressWarnings({"unused", "EnhancedSwitchMigration", "ClassCanBeRecord", "NewClassNamingConvention", "RedundantSuppression"})
    public static class Builder {
        private String frame = "";
        private String mark1 = "";
        private String mark2 = "";
        private String mark3 = "";
        private String totalScore = "";
        public Builder setFrame(String frame) {
            this.frame = frame;
            return this;
            }
        public Builder setMark1(String mark1) {
            this.mark1 = mark1;
            return this;
            }
        public Builder setMark2(String mark2) {
            this.mark2 = mark2;
            return this;
            }
        public Builder setMark3(String mark3) {
            this.mark3 = mark3;
            return this;
            }
        public Builder setTotalScore(String totalScore) {
            this.totalScore = totalScore;
            return this;
            }
        public Builder  setCompare() {
            frame = "?DNC?";
            mark1 = "?DNC?";
            mark2 = "?DNC?";
            mark3 = "?DNC?";
            totalScore = "?DNC?";
            return this;
            }
        public FrameDisplay build(){
             return new FrameDisplay(
                 frame
                 ,mark1
                 ,mark2
                 ,mark3
                 ,totalScore
                );   } 
        } 
        @Override
        public String toString() {
            return "FrameDisplay {"
             +"frame = " + frame + " "
             +"mark1 = " + mark1 + " "
             +"mark2 = " + mark2 + " "
             +"mark3 = " + mark3 + " "
             +"totalScore = " + totalScore + " "
             + "} " + "\n"; }

    public String toJson() {
        return " {"
         +""+"frame:" + "\"" + frame + "\""
         + ","         +""+"mark1:" + "\"" + mark1 + "\""
         + ","         +""+"mark2:" + "\"" + mark2 + "\""
         + ","         +""+"mark3:" + "\"" + mark3 + "\""
         + ","         +""+"totalScore:" + "\"" + totalScore + "\""
                + "} " ; }

        public static FrameDisplay fromJson(String json) {
              FrameDisplay instance = new FrameDisplay();

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
              case "mark1":
                  instance.mark1 = value;
                  break;
              case "mark2":
                  instance.mark2 = value;
                  break;
              case "mark3":
                  instance.mark3 = value;
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


             public static String listToJson(List<FrameDisplay> list) {
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

             public static List<FrameDisplay> listFromJson(String json) {
                    List<FrameDisplay> list = new ArrayList<>();
            		json = json.replaceAll("\\s", "");
            		json = json.replaceAll("\\[","").replaceAll("]","");
                    String[] jsonObjects = json.split("(?<=\\}),\\s*(?=\\{)");
                    for (String jsonObject : jsonObjects) {
                         list.add(FrameDisplay.fromJson(jsonObject));
                         }
                    return list;
                }

    FrameDisplayInternal toFrameDisplayInternal() {
        return new FrameDisplayInternal(
         frame
        , mark1
        , mark2
        , mark3
        , totalScore
        ); }
    }
