package ru.geekbrains.java2.lesson_01.Team;

public class Team {
    private Competitor[] competitors;

    public Team(Competitor... c) {
        competitors = c;
    }

    public void showResults(){
        System.out.println("=========================================");
        for (Competitor c: competitors) {
            c.info();
        }
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }
}
