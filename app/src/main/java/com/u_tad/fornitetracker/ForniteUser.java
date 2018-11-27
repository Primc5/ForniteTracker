package com.u_tad.fornitetracker;

public class ForniteUser {
    private Stats stats;

    public void setStats(Stats stats){
        this.stats = stats;
    }

    public Stats getStats(){
        return stats;
    }
    class Stats{
        private Player player;

        public void setPlayer(Player player){
            this.player = player;
        }

        public Player getPlayer(){
            return player;
        }
        class Player{
            private String value;
            private String title;
            private String rank;

            public void setValue(String value){
                this.value = value;
            }

            public void setTitle(String title){
                this.title = title;
            }

            public void setRank(String rank){
                this.rank = rank;
            }


            public String getValue(){
                return value;
            }

            public String getTitle(){
                return title;
            }

            public String getRank(){
                return rank;
            }
        }
    }
}
