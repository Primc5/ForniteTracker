package com.u_tad.fornitetracker;

public class ForniteUser {
    private Stats stats;
    class Stats{
        private Player player;
        class Player{
            private String value;
            private String title;
            private String rank;
        }
    }
}
