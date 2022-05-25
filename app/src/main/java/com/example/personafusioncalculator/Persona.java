package com.example.personafusioncalculator;

enum Arcana {
    Fool, Magician, Priestess, Empress, Emperor, Hierophant, Lovers, Chariot, Justice, Hermit, Fortune,
    Strength, Hanged_Man, Death, Temperance, Devil, Tower, Star, Moon, Sun, Judgement, Faith, Consultant,
    World
}

enum Type {
    Physical, Gun, Fire, Ice, Electricty, Wind, Psychic, Nuclear, Bless, Curse, Ailment,
    Aid, Almighty, Support, Passive
}

enum Resistance {
    Weak, Resist, Absorb, Normal, Repel;
}

class Skill
{
    //The name of the skill
    private String name;

    //The cost of using the skill
    private String cost;

    //The type of the skill
    private Type type;

    //The effect of the Skill, this is basically the text of what the skill does
    private String effect;

    public Skill(String _name, int _type, String des, String _cost)
    {
        name = _name;
        type = Type.values()[_type];
        effect = des;
        cost = _cost;
    }

    public Skill(String _name, Type _type, String description, String _cost)
    {
        name = _name;
        cost = _cost;
        type = _type;
        effect = description;
    }

    public Type getType()
    { return type; }

    public String getName()
    { return name; }

    public String getCost()
    { return cost; }

    public String getEffect()
    { return effect; }
}

public class Persona {

    private String name;
    private int level;
    private int cost; //costs in the game don't deal with decimal places

    private Trait trait;
    private Arcana arcana;
    private Resistance[] resistances;
    private Skill[] skillList;

    //stats
    private int strength;
    private int magic;
    private int endurance;
    private int agility;
    private int luck;

    public Persona(String na, int lvl, Arcana arc, Resistance[] reses, int[] stats, Trait trt)
    {
        name = na;
        level = lvl;
        arcana = arc;
        resistances = reses;
        trait = trt;

        strength = stats[0];
        magic = stats[1];
        endurance = stats[2];
        agility = stats[3];
        luck = stats[4];
    }

    public int getCost()
    { return cost; }

    public String getName()
    { return name;}

    public int getLevel()
    {return level;}

    public Arcana getArcana()
    { return arcana;}

    public Resistance[] getResistances()
    { return resistances; }

    public Skill[] getSkillList()
    { return skillList; }

    public int[] getAllStats()
    { return new int[]{strength, magic, endurance, agility, luck}; }

    public void setCost(int num)
    {
        cost = num;
    }

    public void setSkills(Skill[] list)
    { skillList = list; }

    public int alphabetiseCompareTo(Persona other)
    {
        if(equals(other))
            return 0;

        if(arcana.ordinal() < other.arcana.ordinal())
            return -1;
        else if(arcana.ordinal() > other.arcana.ordinal())
            return 1;
        else
        {
            if(level < other.level)
                return -1;
            else
                return 1;
        }
    }

    public boolean equals(Persona other)
    { return name.equalsIgnoreCase(other.name); }
}

class SkillPair
{
    public Skill skill;
    public int level;
}

class Trait
{
    String name;
    String description;
    boolean dlc;
}

class AdvancedPersona extends Persona
{
    Persona[] recipe;

    public AdvancedPersona(String na, int lvl, Arcana arc, Resistance[] reses, int[] stats, Trait trt, Persona[] rec)
    {
        super(na, lvl, arc, reses, stats, trt);
        recipe = rec;
    }

    public Persona[] getRecipe()
    { return recipe; }
}

class TreasureDemon extends Persona
{
    private int[] tierChart;

    public TreasureDemon(String na, int lvl, Arcana arc, Resistance[] reses, int[] stats, Trait trt, int[] chart)
    {
        super(na, lvl, arc, reses, stats, trt);
        tierChart = chart;
    }
}