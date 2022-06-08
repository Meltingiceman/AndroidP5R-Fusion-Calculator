package com.example.personafusioncalculator;

enum Arcana {
    Fool, Magician, Priestess, Empress, Emperor, Hierophant, Lovers, Chariot, Justice, Hermit, Fortune,
    Strength, Hanged_Man, Death, Temperance, Devil, Tower, Star, Moon, Sun, Judgement, Faith, Councillor,
    World
}

enum Type {
    Physical, Gun, Fire, Ice, Elec, Wind, Psychic, Nuclear, Bless, Curse, Ailment,
    Aid, Almighty, Support, Passive
}

enum Resistance {
    Weak, Resist, Absorb, Normal, Repel, Null;
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

class SkillSlot
{
    public Skill skill;
    public int level;

    public SkillSlot(Skill skill, int lvl)
    {
        this.skill = skill;
        this.level = lvl;
    }
}

class Trait
{
    String name;
    String description;
    boolean dlc;

    public Trait(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public Trait(String name, String description, boolean dlc)
    {
        this.name = name;
        this.description = description;
        this.dlc = dlc;
    }
}

public class Persona {

    private String name;
    private int level;
    private int cost; //costs in the game don't deal with decimal places

    private Trait trait;
    private Arcana arcana;
    private Resistance[] resistances;
    private SkillSlot[] skillList;

    //stats
    private int strength;
    private int magic;
    private int endurance;
    private int agility;
    private int luck;

    private Type inherits;
    private String item;
    private String itemR;
    private boolean dlc;

    public Persona(Arcana arcana, String name, int lvl, int[] stats, Resistance[] resistances,
                   SkillSlot[] skills, String item, String itemR, Trait trait, Type inherits )
    {
        this.name = name;
        this.level = lvl;
        this.arcana = arcana;
        this.item = item;
        this.itemR = itemR;

        this.strength = stats[0];
        this.magic = stats[1];
        this.endurance = stats[2];
        this.agility = stats[3];
        this.luck = stats[4];

        this.resistances = resistances;
        this.skillList = skills;
        this.inherits = inherits;
        this.trait = trait;
        dlc = false;
    }

    public Persona(Arcana arcana, String name, int lvl, int[] stats, Resistance[] resistances,
                   SkillSlot[] skills, String item, String itemR, Trait trait, Type inherits ,
                   boolean _dlc)
    {
        this(arcana, name, lvl, stats, resistances, skills, item, itemR, trait, inherits);
        dlc = _dlc;
    }

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

    public Persona(String na, int lvl, Arcana arc, Resistance[] reses, int[] stats)
    {
        name = na;
        level = lvl;
        arcana = arc;
        resistances = reses;

        strength = stats[0];
        magic = stats[1];
        endurance = stats[2];
        agility = stats[3];
        luck = stats[4];
    }

    public Persona(String name, int lvl, Arcana arcana, String item, String itemR, int[] stats,
                   Resistance[] resistances, SkillSlot[] skills, Type inherits)
    {
        this.name = name;
        this.level = lvl;
        this.arcana = arcana;
        this.item = item;
        this.itemR = itemR;

        this.strength = stats[0];
        this.magic = stats[1];
        this.endurance = stats[2];
        this.agility = stats[3];
        this.luck = stats[4];

        this.resistances = resistances;
        this.skillList = skills;
        this.inherits = inherits;
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

    public SkillSlot[] getSkillList()
    { return skillList; }

    public int[] getAllStats()
    { return new int[]{strength, magic, endurance, agility, luck}; }

    public void setCost(int num)
    {
        cost = num;
    }

    public void setSkills(SkillSlot[] list)
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



class AdvancedPersona extends Persona
{
    Persona[] recipe;

    public AdvancedPersona(Arcana arcana, String name, int lvl, int[] stats, Resistance[] resistances, SkillSlot[] skills,
                           String item, String itemR, Trait trait, Persona[] recipe, Type inherits )
    {
        super(arcana, name, lvl, stats, resistances, skills, item, itemR, trait, inherits);
        this.recipe = recipe;
    }

    public AdvancedPersona(Arcana arcana, String name, int lvl, int[] stats, Resistance[] resistances, SkillSlot[] skills,
                           String item, String itemR, Trait trait, Persona[] recipe, Type inherits, boolean _dlc)
    {
        super(arcana, name, lvl, stats, resistances, skills, item, itemR, trait, inherits, _dlc);
        this.recipe = recipe;
    }

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
    private Trait[] traits;

    public TreasureDemon(Arcana arcana, String name, int lvl, int[] stats, Resistance[] resistances, SkillSlot[] skills,
                         String item, String itemR, Trait[] traits, int[] tierChart, Type inherits )
    {
        super(name, lvl, arcana, item, itemR, stats, resistances, skills, inherits);
        this.tierChart = tierChart;
        this.traits = traits;
    }

    public TreasureDemon(String na, int lvl, Arcana arc, Resistance[] reses, int[] stats, Trait[] trts, int[] chart)
    {
        super(na, lvl, arc, reses, stats);
        this.tierChart = chart;
        this.traits = trts;
    }

    public int[] getChar()
    { return this.tierChart; }

    public Trait[] getTraits()
    { return this.traits; }
}