package gherkinexecutor.Feature_Bowling;
import org.junit.jupiter.api.*;
import java.util.List;
class Feature_Bowling{


    @Test
    void test_Scenario_Domain_Term_Roll(){
         Feature_Bowling_glue feature_Bowling_glue_object = new Feature_Bowling_glue();

        List<ValueValid> objectList1 = List.of(
             new ValueValid.Builder()
                .setValue("0")
                .setValid("true")
                .setNotes("")
                .build()
            , new ValueValid.Builder()
                .setValue("10")
                .setValid("true")
                .setNotes("")
                .build()
            , new ValueValid.Builder()
                .setValue("11")
                .setValid("false")
                .setNotes("")
                .build()
            , new ValueValid.Builder()
                .setValue("-2")
                .setValid("false")
                .setNotes("")
                .build()
            , new ValueValid.Builder()
                .setValue("-1")
                .setValid("true")
                .setNotes("Used for To Be Rolled")
                .build()
            );
        feature_Bowling_glue_object.Rule_Roll_is_between_0_and_10(objectList1);
        }
    @Test
    void test_Scenario_Adding_a_roll(){
         Feature_Bowling_glue feature_Bowling_glue_object = new Feature_Bowling_glue();

        List<List<String>> stringListList1 = List.of(
           List.of(
            "5"
            ,"5"
            ,"4"
            ,"5"
            ,"8"
            ,"2"
            ,"10"
            ,"0"
            ,"10"
            ,"10"
            ,"6"
            ,"2"
            ,"10"
            ,"4"
            ,"6"
            ,"10"
            )
            );
        feature_Bowling_glue_object.Given_rolls_are(stringListList1);

        List<List<String>> stringListList2 = List.of(
           List.of(
            "10"
            )
            );
        feature_Bowling_glue_object.When_roll_is(stringListList2);

        List<List<String>> stringListList3 = List.of(
           List.of(
            "5"
            ,"5"
            ,"4"
            ,"5"
            ,"8"
            ,"2"
            ,"10"
            ,"0"
            ,"10"
            ,"10"
            ,"6"
            ,"2"
            ,"10"
            ,"4"
            ,"6"
            ,"10"
            ,"10"
            )
            );
        feature_Bowling_glue_object.Then_rolls_become(stringListList3);
        }
    @Test
    void test_Scenario_Full_Game_Compute_and_Display(){
         Feature_Bowling_glue feature_Bowling_glue_object = new Feature_Bowling_glue();

        List<List<String>> stringListList1 = List.of(
           List.of(
            "5"
            ,"5"
            ,"4"
            ,"5"
            ,"8"
            ,"2"
            ,"10"
            ,"0"
            ,"10"
            ,"10"
            ,"6"
            ,"2"
            ,"10"
            ,"4"
            ,"6"
            ,"10"
            ,"10"
            )
            );
        feature_Bowling_glue_object.Given_rolls_are(stringListList1);

        feature_Bowling_glue_object.When_scored();

        String string3 =
            """
            |5/ |45 |8/ |X  |-/ |X  |62 |X  |4/ |XX |
            | 14| 23| 43| 63| 83|101|109|129|149|   |
            """.stripIndent();
        feature_Bowling_glue_object.Then_display_is(string3);
        }
    @Test
    void test_Scenario_A_Game_in_Steps(){
         Feature_Bowling_glue feature_Bowling_glue_object = new Feature_Bowling_glue();

        List<List<String>> stringListList1 = List.of(
           List.of(
            "5"
            ,"5"
            ,"4"
            ,"5"
            ,"8"
            ,"2"
            ,"10"
            ,"0"
            ,"10"
            ,"10"
            ,"6"
            ,"2"
            ,"10"
            ,"4"
            ,"6"
            ,"10"
            ,"10"
            )
            );
        feature_Bowling_glue_object.Given_rolls_are(stringListList1);

        feature_Bowling_glue_object.When_scored();

        List<FrameValues> objectList3 = List.of(
             new FrameValues.Builder()
                .setFrame("1")
                .setRoll1("5")
                .setRoll2("5")
                .setRoll3("4")
                .setScore("14")
                .setTotalScore("14")
                .build()
            , new FrameValues.Builder()
                .setFrame("2")
                .setRoll1("4")
                .setRoll2("5")
                .setRoll3("8")
                .setScore("9")
                .setTotalScore("23")
                .build()
            , new FrameValues.Builder()
                .setFrame("3")
                .setRoll1("8")
                .setRoll2("2")
                .setRoll3("10")
                .setScore("20")
                .setTotalScore("43")
                .build()
            , new FrameValues.Builder()
                .setFrame("4")
                .setRoll1("10")
                .setRoll2("0")
                .setRoll3("10")
                .setScore("20")
                .setTotalScore("63")
                .build()
            , new FrameValues.Builder()
                .setFrame("5")
                .setRoll1("0")
                .setRoll2("10")
                .setRoll3("10")
                .setScore("20")
                .setTotalScore("83")
                .build()
            , new FrameValues.Builder()
                .setFrame("6")
                .setRoll1("10")
                .setRoll2("6")
                .setRoll3("2")
                .setScore("18")
                .setTotalScore("101")
                .build()
            , new FrameValues.Builder()
                .setFrame("7")
                .setRoll1("6")
                .setRoll2("2")
                .setRoll3("10")
                .setScore("8")
                .setTotalScore("109")
                .build()
            , new FrameValues.Builder()
                .setFrame("8")
                .setRoll1("10")
                .setRoll2("4")
                .setRoll3("6")
                .setScore("20")
                .setTotalScore("129")
                .build()
            , new FrameValues.Builder()
                .setFrame("9")
                .setRoll1("4")
                .setRoll2("6")
                .setRoll3("10")
                .setScore("20")
                .setTotalScore("149")
                .build()
            , new FrameValues.Builder()
                .setFrame("10")
                .setRoll1("10")
                .setRoll2("10")
                .setRoll3("-1")
                .setScore("-1")
                .setTotalScore("-1")
                .build()
            );
        feature_Bowling_glue_object.Then_frame_values_are(objectList3);

        feature_Bowling_glue_object.Given_frame_values_are_as_previous();

        List<FrameDisplay> objectList5 = List.of(
             new FrameDisplay.Builder()
                .setFrame("1")
                .setMark1("5")
                .setMark2("/")
                .setMark3("")
                .setTotalScore("14")
                .build()
            , new FrameDisplay.Builder()
                .setFrame("2")
                .setMark1("4")
                .setMark2("5")
                .setMark3("")
                .setTotalScore("23")
                .build()
            , new FrameDisplay.Builder()
                .setFrame("3")
                .setMark1("8")
                .setMark2("/")
                .setMark3("")
                .setTotalScore("43")
                .build()
            , new FrameDisplay.Builder()
                .setFrame("4")
                .setMark1("X")
                .setMark2("")
                .setMark3("")
                .setTotalScore("63")
                .build()
            , new FrameDisplay.Builder()
                .setFrame("5")
                .setMark1("-")
                .setMark2("/")
                .setMark3("")
                .setTotalScore("83")
                .build()
            , new FrameDisplay.Builder()
                .setFrame("6")
                .setMark1("X")
                .setMark2("")
                .setMark3("")
                .setTotalScore("101")
                .build()
            , new FrameDisplay.Builder()
                .setFrame("7")
                .setMark1("6")
                .setMark2("2")
                .setMark3("")
                .setTotalScore("109")
                .build()
            , new FrameDisplay.Builder()
                .setFrame("8")
                .setMark1("X")
                .setMark2("")
                .setMark3("")
                .setTotalScore("129")
                .build()
            , new FrameDisplay.Builder()
                .setFrame("9")
                .setMark1("4")
                .setMark2("/")
                .setMark3("")
                .setTotalScore("149")
                .build()
            , new FrameDisplay.Builder()
                .setFrame("10")
                .setMark1("X")
                .setMark2("X")
                .setMark3("")
                .setTotalScore("")
                .build()
            );
        feature_Bowling_glue_object.Then_display_values_are(objectList5);

        List<List<String>> stringListList6 = List.of(
           List.of(
            "false"
            )
            );
        feature_Bowling_glue_object.Then_game_complete_is(stringListList6);

        List<InputControlValues> objectList7 = List.of(
             new InputControlValues.Builder()
                .setFrame("10")
                .setRoll("3")
                .setRemaining("10")
                .build()
            );
        feature_Bowling_glue_object.Then_input_control_is(objectList7);
        }
    @Test
    void test_Scenario_Check_for_Game_Complete(){
         Feature_Bowling_glue feature_Bowling_glue_object = new Feature_Bowling_glue();

        List<List<String>> stringListList1 = List.of(
           List.of(
            "5"
            ,"5"
            ,"4"
            ,"5"
            ,"8"
            ,"2"
            ,"10"
            ,"0"
            ,"10"
            ,"10"
            ,"6"
            ,"2"
            ,"10"
            ,"4"
            ,"6"
            ,"10"
            ,"10"
            ,"10"
            )
            );
        feature_Bowling_glue_object.Given_rolls_are(stringListList1);

        feature_Bowling_glue_object.When_scored();

        List<List<String>> stringListList3 = List.of(
           List.of(
            "true"
            )
            );
        feature_Bowling_glue_object.Then_game_complete_is(stringListList3);
        }
    @Test
    void test_Scenario_Values_for_Tenth_Frame(){
         Feature_Bowling_glue feature_Bowling_glue_object = new Feature_Bowling_glue();

        List<List<String>> stringListList1 = List.of(
           List.of(
            "10"
            ,"10"
            )
            );
        feature_Bowling_glue_object.Given_rolls_for_tenth_frame_are(stringListList1);

        feature_Bowling_glue_object.When_scored();

        List<FrameValues> objectList3 = List.of(
             new FrameValues.Builder()
                .setFrame("10")
                .setRoll1("10")
                .setRoll2("10")
                .setRoll3("-1")
                .setScore("-1")
                .setTotalScore("-1")
                .build()
            );
        feature_Bowling_glue_object.Then_Then_tenth_frame_values_are(objectList3);
        }
    @Test
    void test_Scenario_Input_Control_Should_Be_For_Next_Frame(){
         Feature_Bowling_glue feature_Bowling_glue_object = new Feature_Bowling_glue();

        List<List<String>> stringListList1 = List.of(
           List.of(
            "10"
            )
            );
        feature_Bowling_glue_object.Given_rolls_are(stringListList1);

        feature_Bowling_glue_object.When_scored();

        List<InputControlValues> objectList3 = List.of(
             new InputControlValues.Builder()
                .setFrame("2")
                .setRoll("1")
                .setRemaining("10")
                .build()
            );
        feature_Bowling_glue_object.Then_input_control_is(objectList3);
        }
    @Test
    void test_Scenario_Try_to_add_invalid_roll(){
         Feature_Bowling_glue feature_Bowling_glue_object = new Feature_Bowling_glue();

        List<List<String>> stringListList1 = List.of(
           List.of(
            "5"
            )
            );
        feature_Bowling_glue_object.Given_rolls_are(stringListList1);

        feature_Bowling_glue_object.When_scored();

        List<List<String>> stringListList3 = List.of(
           List.of(
            "6"
            )
            );
        feature_Bowling_glue_object.When_roll_is(stringListList3);

        List<List<String>> stringListList4 = List.of(
           List.of(
            "5"
            )
            );
        feature_Bowling_glue_object.Then_rolls_become(stringListList4);
        }
    }

