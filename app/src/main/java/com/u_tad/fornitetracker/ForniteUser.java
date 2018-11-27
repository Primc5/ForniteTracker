package com.u_tad.fornitetracker;

public class ForniteUser {
    private Stats stats;
    private String accountID;
    private Long platformID;
    private String platformName;
    private String platformNameLong;
    private String epicUserHandle;

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    //------------------------------------
    class Stats{
        private EachStat p10;

        public EachStat getP10() {
            return p10;
        }

        public void setP10(EachStat p10) {
            this.p10 = p10;
        }

        //---------------------------------------
        class EachStat{
            private Stat matches;
            private Stat winRatio;
            private Stat kills;
            private Stat kd;

            public Stat getKills() {
                return kills;
            }

            public Stat getKd() {
                return kd;
            }

            public Stat getMatches() {
                return matches;
            }

            public Stat getWinRatio() {
                return winRatio;
            }

            public void setKd(Stat kd) {
                this.kd = kd;
            }

            public void setKills(Stat kills) {
                this.kills = kills;
            }

            public void setMatches(Stat matches) {
                this.matches = matches;
            }

            public void setWinRatio(Stat winRatio) {
                this.winRatio = winRatio;
            }

            //-------------------------------------
    class Stat{
        private String label;
        private String field;
        private String category;
        private Double valueDec;
        private String value;
        private Long rank;
        private Double percentile;
        private String displayValue;

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

    public Long getRank() {
        return rank;
    }
}
        }

    }


}
