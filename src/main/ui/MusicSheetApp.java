package ui;

import model.SheetMusic;

import java.util.ArrayList;

public class MusicSheetApp {
    private SheetMusic score;
    private ArrayList<String> titleList;
    private String scoreTitle;


    //EFFECTS: Constructs a music
    public MusicSheetApp() {
        runMusicSheet();
    }

    private void runMusicSheet() {

    }


    /* EFFECTS: View my music sheet
     */
    public SheetMusic viewMusicSheet(String name) {
        this.titleList = new ArrayList<>();
        if (titleList.contains(name)) {
            System.out.println("Here is " + name + "!");
            return score;
        } else {
            System.out.println("Sorry, " + name + "does not exist.");
            return null;
        }
    }

    /* EFFECTS: Saves notes to music sheet
     */
    public String saveNotes(String title) {
        this.titleList = new ArrayList<>();
        scoreTitle = title;
        titleList.add(title);
        System.out.println(titleList + " is saved!");
        return title;
    }

}
