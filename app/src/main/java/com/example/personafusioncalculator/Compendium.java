package com.example.personafusioncalculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;


public class Compendium {
    private final int AMT_ARCANA = 23;
    private final int AMT_PERSONA = 232;

    private Skill[][] skillList = new Skill[][]
	{
		{
			new Skill("Lunge", 0, " Light Physical damage to 1 foe.", "5%"),
			new Skill("Cleave", 0, " Light Physical damage to 1 foe.", "6%"),
			new Skill("Power Slash", 0, " Medium Physical damage to 1 foe.", "10%"),
			new Skill("Assault Dive", 0, " Heavy Physical damage to 1 foe.", "13%"),
			new Skill("Megaton Raid", 0, " Severe Physical damage to 1 foe.", "16%"),
			new Skill("Brave Blade", 0, " Colossal Physical damage to 1 foe.", "21%"),
			new Skill("God's Hand", 0, " Colossal Physical damage to 1 foe.", "22%"),
			new Skill("Sword Dance", 0, " Colossal Physical damage to 1 foe.", "25%"),
			new Skill("Giant Slice", 0, " Medium Physical damage to 1 foe (Stronger under Baton Pass).", "9%"),
			new Skill("Rising Slash", 0, " Heavy Physical damage to 1 foe (Stronger under Baton Pass).", "14%"),
			new Skill("Deadly Fury", 0, " Severe Physical damage to 1 foe (Stronger under Baton Pass).", "18%"),
			new Skill("Double Fangs", 0, " Light Physical damage to 1 foe 2x.", "10%"),
			new Skill("Kill Rush", 0, " Light Physical damage to 1 foe 1x to 3x.", "14%"),
			new Skill("Gatling Blows", 0, " Light Physical damage to 1 foe 3x to 4x.", "16%"),
			new Skill("Tempest Slash", 0, " Minuscule Physical damage to 1 foe 3x to 5x.", "17%"),
			new Skill("Myriad Slashes", 0, " Medium Physical damage to 1 foe 2x to 3x.", "20%"),
			new Skill("Terror Claw", 0, " Light Physical damage and inflict Fear (medium odds) to 1 foe.", "8%"),
			new Skill("Headbutt", 0, " Light Physical damage and inflict Forget (medium odds) to 1 foe.", "9%"),
			new Skill("Hysterical Slap", 0, " Light Physical damage and inflict Rage (medium odds) to 1 foe.", "9%"),
			new Skill("Brain Shake", 0, " Light Physical damage and inflict Brainwash (medium odds) to 1 foe.", "9%"),
			new Skill("Sledgehammer", 0, " Medium Physical damage and inflict Dizzy (medium odds) to 1 foe.", "10%"),
			new Skill("Skull Cracker", 0, " Medium Physical damage and inflict Confusion (medium odds) to 1 foe.", "10%"),
			new Skill("Negative Pile", 0, " Heavy Physical damage and inflict Despair (medium odds) to 1 foe.", "12%"),
			new Skill("Death Scythe", 0, " Severe Physical damage and inflict Fear (medium odds) to 1 foe.", "20%"),
			new Skill("Lucky Punch", 0, " Minuscule Physical damage to 1 foe with high critical rate.", "8%"),
			new Skill("Miracle Punch", 0, " Medium Physical damage to 1 foe with high critical rate.", "8%"),
			new Skill("Cornered Fang", 0, " Medium Physical damage to 1 foe (Stronger when surrounded).", "10%"),
			new Skill("Ayamur", 0, " Medium Physical damage to 1 foe 3x with high Accuracy (Unique to Baal).", "25%"),
			new Skill("Laevateinn", 0, " Colossal Physical damage to 1 foe (Unique to Loki and Hereward).", "25%"),
			new Skill("Masquerade", 0, " Severe Physical damage to 1 foe 2x (Unique to Ella).", "25%"),
			new Skill("Cross Slash", 0, " Heavy Physical damage to 1 foe 2x with high accuracy (Unique to Izanagi).", "20%"),
			new Skill("Beast Weaver", 0, " Colossal Physical damage to 1 foe and user's attack power is greatly reduced (independent from -kaja/-nda effects) (Unique to Ariadne).", "20%"),
			new Skill("Vajra Blast", 0, " Medium Physical damage to all foes.", "13%"),
			new Skill("Vicious Strike", 0, " Medium Physical damage to all foes.", "18%"),
			new Skill("Heat Wave", 0, " Heavy Physical damage to all foes.", "20%"),
			new Skill("Vorpal Blade", 0, " Severe Physical damage to all foes.", "23%"),
			new Skill("Gigantomachia", 0, " Colossal Physical damage to all foes.", "25%"),
			new Skill("Rampage", 0, " Light Physical damage to all foes 1x to 3x.", "13%"),
			new Skill("Swift Strike", 0, " Minuscule Physical damage to all foes 2x to 4x.", "17%"),
			new Skill("Deathbound", 0, " Medium Physical damage to all foes 1x to 2x.", "22%"),
			new Skill("Agneyastra", 0, " Medium Physical damage to all foes 1x to 3x.", "24%"),
			new Skill("Memory Blow", 0, " Light Physical damage and inflict Forget (low odds) to all foes.", "15%"),
			new Skill("Dormin Rush", 0, " Medium Physical damage and inflict Sleep (low odds) to all foes.", "16%"),
			new Skill("Oni-Kagura", 0, " Medium Physical damage and inflict Rage (low odds) to all foes.", "16%"),
			new Skill("Flash Bomb", 0, " Medium Physical damage and inflict Dizzy (low odds) to all foes.", "19%"),
			new Skill("Bad Beat", 0, " Medium Physical damage and inflict Despair (low odds) to all foes.", "21%"),
			new Skill("Bloodbath", 0, " Heavy Physical damage and inflict Fear (low odds) to all foes.", "22%"),
			new Skill("Brain Buster", 0, " Heavy Physical damage and inflict Brainwash (low odds) to all foes.", "22%"),
			new Skill("Mind Slice", 0, " Medium Physical damage and inflict Confuse (low odds) to all foes.", "19%"),
			new Skill("Hassou Tobi", 0, " Light Physical damage to all foes 8x (Unique to Yoshitsune).", "25%"),
			new Skill("Miracle Rush", 0, " Medium Physical damage to all foes with high critical rate (Unique to Diego).", "16%"),
			new Skill("Akashic Arts", 0, " Severe Physical damage to all foes 1x to 2x, high critical rate (Unique to Athena).", "20%"),
		},
		{
			new Skill("Snap", 1, " Medium Gun damage to 1 foe.", "9%"),
			new Skill("Double Shot", 1, " Light Gun damage to 1 foe 2x.", "12%"),
			new Skill("One-shot Kill", 1, " Severe Gun damage to 1 foe with high critical rate.", "17%"),
			new Skill("Dream Needle", 1, " Light Gun damage and inflict Sleep (medium odds) to 1 foe.", "8%"),
			new Skill("Triple Down", 1, " Light Gun damage to all foes 3x.", "16%"),
			new Skill("Riot Gun", 1, " Severe Gun damage to all foes.", "24%"),
		},
		{
			new Skill("Agi", 2, " Light Fire damage to 1 foe.", "4"),
			new Skill("Agilao", 2, " Medium Fire damage to 1 foe.", "8"),
			new Skill("Agidyne", 2, " Heavy Fire damage to 1 foe.", "12"),
			new Skill("Inferno", 2, " Severe Fire damage to 1 foe.", "48"),
			new Skill("Maragi", 2, " Light Fire damage to all foes.", "10"),
			new Skill("Maragion", 2, " Medium Fire damage to all foes.", "16"),
			new Skill("Maragidyne", 2, " Heavy Fire damage to all foes.", "22"),
			new Skill("Blazing Hell", 2, " Severe Fire damage to all foes.", "54"),
			new Skill("Titanomachia", 2, " Severe Fire damage to all foes and inflict Fear (high odds) (Unique to Asterius).", "34"),
		},
		{
			new Skill("Bufu", 3, " Light Ice damage to 1 foe.", "4"),
			new Skill("Bufula", 3, " Medium Ice damage to 1 foe.", "8"),
			new Skill("Bufudyne", 3, " Heavy Ice damage to 1 foe.", "12"),
			new Skill("Diamond Dust", 3, " Dust Severe Ice damage to 1 foe.", "48"),
			new Skill("Mabufu", 3, " Light Ice damage to all foes.", "10"),
			new Skill("Mabufula", 3, " Medium Ice damage to all foes.", "16"),
			new Skill("Mabufudyne", 3, " Heavy Ice damage to all foes.", "22"),
			new Skill("Ice Age", 3, " Severe Ice damage to all foes.", "54"),
		},
		{
			new Skill("Zio", 4, " Light Electric damage to 1 foe.", "4"),
			new Skill("Zionga", 4, " Medium Electric damage to 1 foe.", "8"),
			new Skill("Ziodyne", 4, " Heavy Electric damage to 1 foe.", "12"),
			new Skill("Thunder Reign", 4, " Reign Severe Electric damage to 1 foe.", "48"),
			new Skill("Mazio", 4, " Light Electric damage to all foes.", "10"),
			new Skill("Mazionga", 4, " Medium Electric damage to all foes.", "16"),
			new Skill("Maziodyne", 4, " Heavy Electric damage to all foes.", "22"),
			new Skill("Wild Thunder", 4, " Severe Electric damage to all foes.", "54"),
		},
		{
			new Skill("Garu", 5, " Light Wind damage to 1 foe.", "3"),
			new Skill("Garula", 5, " Medium Wind damage to 1 foe.", "6"),
			new Skill("Garudyne", 5, " Heavy Wind damage to 1 foe.", "10"),
			new Skill("Panta Rhei", 5, " Severe Wind damage to 1 foe.", "42"),
			new Skill("Magaru", 5, " Light Wind damage to all foes.", "8"),
			new Skill("Magarula", 5, " Medium Wind damage to all foes.", "14"),
			new Skill("Magarudyne", 5, " Heavy Wind damage to all foes.", "20"),
			new Skill("Vacuum Wave", 5, " Severe Wind damage to all foes.", "48"),
		},
		{
			new Skill("Psi", 6, " Light Psy damage to 1 foe.", "4"),
			new Skill("Psio", 6, " Medium Psy damage to 1 foe.", "8"),
			new Skill("Psiodyne", 6, " Heavy Psy damage to 1 foe.", "12"),
			new Skill("Psycho Force", 6, " Severe Psy damage to 1 foe.", "48"),
			new Skill("Mapsi", 6, " Light Psy damage to all foes.", "10"),
			new Skill("Mapsio", 6, " Medium Psy damage to all foes.", "16"),
			new Skill("Mapsiodyne", 6, " Heavy Psy damage to all foes.", "22"),
			new Skill("Psycho Blast", 6, " Severe Psy damage to all foes.", "54"),
		},
		{
			new Skill("Frei", 7, " Light Nuclear damage to 1 foe.", "4"),
			new Skill("Freila", 7, " Medium Nuclear damage to 1 foe.", "8"),
			new Skill("Freidyne", 7, " Heavy Nuclear damage to 1 foe.", "12"),
			new Skill("Atomic Flare", 7, " Severe Nuclear damage to 1 foe.", "48"),
			new Skill("Mafrei", 7, " Light Nuclear damage to all foes.", "10"),
			new Skill("Mafreila", 7, " Medium Nuclear damage to all foes.", "16"),
			new Skill("Mafreidyne", 7, " Heavy Nuclear damage to all foes.", "22"),
			new Skill("Cosmic Flare", 7, " Severe Nuclear damage to all foes.", "54"),
		},
		{
			new Skill("Kouha", 8, " Light Bless damage to 1 foe.", "4"),
			new Skill("Kouga", 8, " Medium Bless damage to 1 foe.", "8"),
			new Skill("Kougaon", 8, " Heavy Bless damage to 1 foe.", "12"),
			new Skill("Makouha", 8, " Light Bless damage to all foes.", "10"),
			new Skill("Makouga", 8, " Medium Bless damage to all foes.", "16"),
			new Skill("Makougaon", 8, " Heavy Bless damage to all foes.", "22"),
			new Skill("Divine Judgement", 8, " Half remaining HP of 1 foe.", "48"),
			new Skill("Hama", 8, " Small chance of instantly killing 1 foe.", "8"),
			new Skill("Hamaon", 8, " Medium chance of instantly killing 1 foe.", "15"),
			new Skill("Mahama", 8, " Small chance of instantly killing all foes.", "18"),
			new Skill("Mahamaon", 8, " Medium chance of instantly killing all foes.", "34"),
			new Skill("Samsara", 8, " High chance of instantly killing all foes (Unique to Daisoujo).", "44"),
			new Skill("Shining Arrows", 8, " Light Bless damage to all foes 4x to 8x (Unique to Kaguya).", "22"),
		},
		{
			new Skill("Eiha", 9, " Light Curse damage to 1 foe.", "4"),
			new Skill("Eiga", 9, " Medium Curse damage to 1 foe.", "8"),
			new Skill("Eigaon", 9, " Heavy Curse damage to 1 foe.", "12"),
			new Skill("Maeiha", 9, " Light Curse damage to all foes.", "10"),
			new Skill("Maeiga", 9, " Medium Curse damage to all foes.", "16"),
			new Skill("Maeigaon", 9, " Heavy Curse damage to all foes.", "22"),
			new Skill("Demonic Decree", 9, " Half remaining HP of 1 foe.", "48"),
			new Skill("Mudo", 9, " Small chance of instantly killing 1 foe.", "8"),
			new Skill("Mudoon", 9, " Medium chance of instantly killing 1 foe.", "15"),
			new Skill("Mamudo", 9, " Small chance of instantly killing all foes.", "18"),
			new Skill("Mamudoon", 9, " Medium chance of instantly killing all foes.", "34"),
			new Skill("Die For Me!", 9, " High chance of instantly killing all foes (Unique to Alice).", "44"),
			new Skill("Magatsu Mandala", 9, " Heavy Curse damage to all foes and inflict Confuse/Fear/Despair (medium odds) (Unique to Magatsu-Izanagi).", "30"),
			new Skill("Abyssal Wings", 9, " Severe Curse damage to all foes (Unique to Tsukiyomi).", "30"),
		},
		{
			new Skill("Megido", 10, " Medium Almighty damage to all foes.", "15"),
			new Skill("Megidola", 10, " Heavy Almighty damage to all foes.", "24"),
			new Skill("Megidolaon", 10, " Severe Almighty damage to all foes.", "38"),
			new Skill("Life Drain", 10, " Drains HP from 1 foe.", "3"),
			new Skill("Spirit Drain", 10, " Drains SP from 1 foe.", "3"),
			new Skill("Foul Breath", 10, " Increase susceptibility to all ailments of 1 foe.", "8"),
			new Skill("Stagnant Air", 10, " Increase susceptibility to all ailments of all foes and allies.", "5"),
			new Skill("Ghastly Wail", 10, " Instantly kill all foes under Fear.", "28"),
			new Skill("Black Viper", 10, " Severe Almighty damage to 1 foe.", "48"),
			new Skill("Morning Star", 10, " Severe Almighty damage to all foes (Unique to Lucifer).", "52"),
			new Skill("Abyssal Eye", 10, " Severe Almighty damage to all foes (Unique to Hastur).", "50"),
			new Skill("Rebellion Blade", 10, " Colossal Almighty damage to one foe, damage increases if foe is downed (Unique to Hereward).", "99"),
			new Skill("Door of Hades", 10, " Heavy Almighty damage to all foes with medium chance of instant kill (Unique to Thanatos).", "32"),
			new Skill("Myriad Truths", 10, " Heavy Almighty damage to all foes x3 (Unique to Izanagi-no-Okami).", "40"),
		},
		{
			new Skill("Dazzler", 11, " Inflict Dizzy (high odds) to 1 foe.", "5"),
			new Skill("Nocturnal Flash", 11, " Inflict Dizzy (medium odds) to all foes.", "12"),
			new Skill("Makajam", 11, " Inflict Forget (high odds) to 1 foe.", "5"),
			new Skill("Makajamaon", 11, " Inflict Forget (medium odds) to all foes.", "12"),
			new Skill("Dormina", 11, " Inflict Sleep (high odds) to 1 foe.", "5"),
			new Skill("Lullaby", 11, " Inflict Sleep (medium odds) to all foes.", "12"),
			new Skill("Phantom Show", 11, " Inflict Sleep (high odds) to all foes (Unique to Raoul).", "4"),
			new Skill("Pulinpa", 11, " Inflict Confuse (high odds) to 1 foe.", "5"),
			new Skill("Tentarafoo", 11, " Inflict Confuse (medium odds) to all foes.", "12"),
			new Skill("Evil Touch", 11, " Inflict Fear (high odds) to 1 foe.", "5"),
			new Skill("Evil Smile", 11, " Inflict Fear (medium odds) to all foes.", "12"),
			new Skill("Ominous Words", 11, " Inflict Despair (high odds) to 1 foe.", "5"),
			new Skill("Abysmal Surge", 11, " Inflict Despair (medium odds) to all foes.", "12"),
			new Skill("Taunt", 11, " Inflict Rage (high odds) to 1 foe.", "5"),
			new Skill("Wage War", 11, " Inflict Rage (medium odds) to all foes.", "12"),
			new Skill("Marin Karin", 11, " Inflict Brainwash (high odds) to 1 foe.", "5"),
			new Skill("Brain Jack", 11, " Inflict Brainwash (medium odds) to all foes.", "12"),
		},
		{
			new Skill("Dia", 12, " Slightly restore 1 ally's HP.", "3"),
			new Skill("Diarama", 12, " Moderately restore 1 ally's HP.", "6"),
			new Skill("Diarahan", 12, " Fully restore 1 ally's HP.", "18"),
			new Skill("Media", 12, " Slight restore party's HP.", "7"),
			new Skill("Mediarama", 12, " Moderately restore party's HP.", "12"),
			new Skill("Mediarahan", 12, " Fully restore party's HP.", "30"),
			new Skill("Recarm", 12, " Revive 1 ally with 50% HP recovered.", "8"),
			new Skill("Samarecarm", 12, " Revive 1 ally with all HP recovered.", "18"),
			new Skill("Baisudi", 12, " Cure Burn/Freeze/Shock of 1 ally.", "4"),
			new Skill("Mabaisudi", 12, " Cure Burn/Freeze/Shock of party.", "8"),
			new Skill("Patra", 12, " Cure Dizzy/Forget/Sleep/Hunger of 1 ally.", "4"),
			new Skill("Me Patra", 12, " Cure Dizzy/Forget/Sleep/Hunger of party.", "8"),
			new Skill("Energy Drop", 12, " Cure Confuse/Fear/Despair/Rage/Brainwash of 1 ally.", "4"),
			new Skill("Energy Shower", 12, " Cure Confuse/Fear/Despair/Rage/Brainwash of party.", "8"),
			new Skill("Amrita Drop", 12, " Cure all ailments of 1 ally except for special status.", "6"),
			new Skill("Amrita Shower", 12, " Cure all ailments of party except for special status.", "12"),
			new Skill("Salvation", 12, " Fully restore HP and cure all ailments of party except for special status.", "48"),
			new Skill("Holy Benevolence", 12, " Revive all allies with all HP recovered (Unique to Maria).", "27"),
			new Skill("Cadenza", 12, " Restore 50% HP of party and increase evasion rate (Unique to Orpheus).", "24"),
			new Skill("Neo Cadenza", 12, " Cadenza Restore 50% HP of party, increase evasion rate, Attack and Defense (Unique to Orpheus F).", "24"),
			new Skill("Oratorio", 12, " Fully restore party's HP and negate all -nda debuffs (Unique to Messiah).", "38"),
			new Skill("Champion's Cup&", 12, " Moderately restore 1 ally's HP and increase Attack power for 3 turns.", "10"),
		},
		{
			new Skill("Tarukaja", 13, " Increase 1 ally's Attack power for 3 turns.", "8"),
			new Skill("Rakukaja", 13, " Increase 1 ally's Defense for 3 turns.", "8"),
			new Skill("Sukukaja", 13, " Increase 1 ally's Agility for 3 turns.", "8"),
			new Skill("Heat Riser", 13, " Increase 1 ally's Attack, Defense and Agility for 3 turns.", "30"),
			new Skill("Matarukaja", 13, " Increase party's Attack power for 3 turns.", "24"),
			new Skill("Marakukaja", 13, " Increase party's Defense for 3 turns.", "24"),
			new Skill("Masukukaja", 13, " Increase party's Agility for 3 turns.", "24"),
			new Skill("Thermopylae", 13, " Increase party's Attack, Defense and Agility for 3 turns if the party is being ambushed.", "30"),
			new Skill("Hyakka Ryouran", 13, " Increase party's Attack, Defense and Agility for 3 turns (Unique to Gorokichi).", "90"),
			new Skill("Tarunda", 13, " Decrease 1 foe's Attack power for 3 turns.", "8"),
			new Skill("Rakunda", 13, " Decrease 1 foe's Defense for 3 turns.", "8"),
			new Skill("Sukunda", 13, " Decrease 1 foe's Agility for 3 turns.", "8"),
			new Skill("Debilitate", 13, " Decrease 1 foe's Attack, Defense and Agility for 3 turns.", "30"),
			new Skill("Matarunda", 13, " Decrease all foes' Attack power for 3 turns.", "24"),
			new Skill("Marakunda", 13, " Decrease all foes' Defense for 3 turns.", "24"),
			new Skill("Masukunda", 13, " Decrease all foes' Agility for 3 turns.", "24"),
			new Skill("Checkmate", 13, " Decrease all foes' Attack, Defense and Agility for 3 turns (Unique to Agnes).", "90"),
			new Skill("Vault Guardian&", 13, " Increases Defense for all allies for 3 turns and automatic Tetrakarn/Makarakarn at the start of battle.", "20"),
			new Skill("Gambler's Foresight&", 13, " Increases Agility for all allies for 3 turns, and automatic Concentrate at the start of battle.", "20"),
			new Skill("Rebellion", 13, "Increase 1 ally's critical rate for 3 turns.", "5"),
			new Skill("Brave Step", 13, "Increase Party's critical rate for 3 turns (Unique to Cendrillon).", "16"),
			new Skill("Revolution", 13, "Increase all foes and allies' critical rate for 3 turns.", "5"),
			new Skill("Charge", 13, "Multiply user's next Physical or Gun Attack damage by 2.5.", "15"),
			new Skill("Concentrate", 13, "Multiply user's next Magic attack damage by 2.5", "15"),
			new Skill("Fighting Spirit", 13, "Multiply party's next Physical attack damage by 2.5 (Unique to William).", "80"),
			new Skill("High Energy", 13, "Multiply party's nect magic attack damage by 2.5 (Unique to Célestine).", "80"),
			new Skill("Tyrant's Will&", 13, "Multiply one ally's next Physical or Gun attack damage by 2.5 and Automatic Rakukaja at the start of the battle", "20"),
			new Skill("President's Insight&", 13, "Multiply one ally's next Physical or Gun attack damage by 2.5. Automatic Rakukaja at the start of battle.", "20"),
			new Skill("Wings of Wisdom&", 13, "Cures all non-special ailments for all allies. Automatic Sukukaja at the start of battle.", "10"),
			new Skill("Guiding Tendril&", 13, "Down all foes. Only usable during preemptive attack. Recover 8% HP and SP after victory.", "40"),
			new Skill("Fire Wall", 13, "Erect a shield on 1 ally to reduce Fire damage and cover innate Fire weakness for 3 turns.", "18"),
			new Skill("Ice Wall", 13, "Erect a shield on 1 ally to reduce Ice damage and cover innate Ice weakness for 3 turns.", "18"),
			new Skill("Elec Wall", 13, "Erect a shield on 1 ally to reduce Electric damage and cover innate Electric weakness for 3 turns.", "18"),
			new Skill("Wind Wall", 13, "Erect a shield on 1 ally to reduce Wind damage and cover innate Wind weakness for 3 turns.", "18"),
			new Skill("Psy Wall", 13, "Erect a shield on 1 ally to reduce Psychic damage and cover innate Psychic weakness for 3 turns.", "18"),
			new Skill("Nuke Wall", 13, "Erect a shield on 1 ally to reduce Nuclear damage and cover innate Nuclear weakness for 3 turns.", "18"),
			new Skill("Tetraja", 13, "Erect shields on party to nullify one instant death attack of Bless or Curse types.", "24"),
			new Skill("Tetrakarn", 13, "Erect a shield on 1 ally to repel 1 (non-Almighty) Physical or Gun attack.", "36"),
			new Skill("Makarakarn", 13, "Erect a shield on 1 ally to repel 1 (non-Almighty) magical attack.", "36"),
			new Skill("Life Wall", 13, "Erect a shield on all allies to repel 1 (non-Almighty) attack (Unique to Lucy).", "95"),
			new Skill("Bleeding Dry Brush&", 13, "Forms a barrier that can absorb one attack (except Almighty). Nullifies wearer's weaknesses.", "22"),
			new Skill("Dekaja", 13, "Negate all -kaja buff effects of all foes.", "10"),
			new Skill("Dekunda", 13, "Negate all -nda debuff effects of party.", "10"),
			new Skill("Fire Break", 13, "Suppress innate Fire resistances of all foes for 3 turns.", "15"),
			new Skill("Ice Break", 13, "Suppress innate Ice resistances of all foes for 3 turns.", "15"),
			new Skill("Elec Break", 13, "Suppress innate Electric resistances of all foes for 3 turns.", "15"),
			new Skill("Wind Break", 13, "Suppress innate Wind resistances of all foes for 3 turns.", "15"),
			new Skill("Psy Break", 13, "Suppress innate Psychic resistances of all foes for 3 turns.", "15"),
			new Skill("Nuke Break", 13, "Suppress innate Nuclear resistances of all foes for 3 turns.", "15"),
			new Skill("Tetra Break", 13, "Remove physical-repellent shields from all foes.", "18"),
			new Skill("Makara Break", 13, "Remove magic-repellent shields from all foes.", "18")
		},
		{
			new Skill("Counter", 14, " 10% chance of reflecting Physical attacks.", "-"),
			new Skill("Counterstrike", 14, " 15% chance of reflecting Physical attacks.", "-"),
			new Skill("High Counter", 14, " 20% chance of reflecting Physical attacks.", "-"),
			new Skill("Fire Boost", 14, " Strengthen Fire attacks by 25%.", "-"),
			new Skill("Ice Boost", 14, " Strengthen Ice attacks by 25%.", "-"),
			new Skill("Elec Boost", 14, " Strengthen Electric attacks by 25%.", "-"),
			new Skill("Wind Boost", 14, " Strengthen Wind attacks by 25%.", "-"),
			new Skill("Psy Boost", 14, " Strengthen Psy attacks by 25%.", "-"),
			new Skill("Nuke Boost", 14, " Strengthen Nuclear attacks by 25%.", "-"),
			new Skill("Bless Boost", 14, " Strengthen (non instant death) Bless attacks by 25%.", "-"),
			new Skill("Curse Boost", 14, " Strengthen (non instant death) Curse attacks by 25%.", "-"),
			new Skill("Almighty Boost", 14, " Strengthen Almighty attacks by 25%.", "-"),
			new Skill("Fire Amp", 14, " Strengthen Fire attacks by 50%.", "-"),
			new Skill("Ice Amp", 14, " Strengthen Ice attacks by 50%.", "-"),
			new Skill("Elec Amp", 14, " Strengthen Electric attacks by 50%.", "-"),
			new Skill("Wind Amp", 14, " Strengthen Wind attacks by 50%.", "-"),
			new Skill("Psy Amp", 14, " Strengthen Psy attacks by 50%.", "-"),
			new Skill("Nuke Amp", 14, " Strengthen Nuclear attacks by 50%.", "-"),
			new Skill("Bless Amp", 14, " Strengthen (non instant death) Bless attacks by 50%.", "-"),
			new Skill("Curse Amp", 14, " Amp Strengthen (non instant death) Curse attacks by 50%.", "-"),
			new Skill("Almighty", 14, " Amp Strengthen Almighty attacks by 50%.", "-"),
			new Skill("Hama Boost", 14, " Increase success rate of instant death by Bless skills.", "-"),
			new Skill("Mudo Boost", 14, " Increase success rate of instant death by Curse skills.", "-"),
			new Skill("Burn Boost", 14, " Increase chance of inflicting Burn.", "-"),
			new Skill("Freeze Boost", 14, " Increase chance of inflicting Freeze.", "-"),
			new Skill("Shock Boost", 14, " Increase chance of inflicting Shock.", "-"),
			new Skill("Dizzy Boost", 14, " Increase chance of inflicting Dizzy.", "-"),
			new Skill("Forget Boost", 14, " Increase chance of inflicting Forget.", "-"),
			new Skill("Sleep Boost", 14, " Increase chance of inflicting Sleep.", "-"),
			new Skill("Confuse Boost", 14, " Increase chance of inflicting Confuse.", "-"),
			new Skill("Fear Boost", 14, " Increase chance of inflicting Fear.", "-"),
			new Skill("Despair Boost", 14, " Increase chance of inflicting Despair.", "-"),
			new Skill("Rage Boost", 14, " Increase chance of inflicting Rage.", "-"),
			new Skill("Brainwash Boost", 14, " Increase chance of inflicting Brainwash.", "-"),
			new Skill("Ailment Boost", 14, " Increase chance of inflicting all ailments.", "-"),
			new Skill("Ambient Aid", 14, " Greatly increase inflicting rate of all status effects under rainy day or special weather warning.", "-"),
			new Skill("Adverse Resolve", 14, " Increase critical rate when being ambushed.", "-"),
			new Skill("Touch n' Go", 14, " Apply Sukukaja when performing Baton Pass.", "-"),
			new Skill("Apt Pupil", 14, " Increase critical rate.", "-"),
			new Skill("Arms Master", 14, " Half HP cost for physical skills.", "-"),
			new Skill("Spell Master", 14, " Half SP cost for magic skills.", "-"),
			new Skill("Kuzunoha Emblem&", 14, " Decreases HP and SP cost of skills by 25%.", "-"),
			new Skill("Gun Boost", 14, " Strengthen Gun attacks by 25%.", "-"),
			new Skill("Gun Amp", 14, " Strengthen Gun attacks by 50%.", "-"),
			new Skill("Trigger Happy", 14, " Increase critical rate of Gun attacks.", "-"),
			new Skill("Fortified Moxy", 14, " Increase critical rate when beginning battle with preemptive turn.", "-"),
			new Skill("Magic Ability", 14, " Strengthen all magical attacks by 25%.", "-"),
			new Skill("Tyrant's Mind", 14, " Strengthen all attacks, Stacks with passives (Unique to Satanael).", "-"),
			new Skill("All-Out Attack Boost&", 14, " Wearer's All-Out Attack power is boosted.", "-"),
			new Skill("Gun Accuracy + 5%&", 14, " Gun accuracy is increased by 5%.", "-"),
			new Skill("Resist Phys", 14, " Reduce damage from Physical attacks.", "-"),
			new Skill("Resist Fire", 14, " Reduce damage from Fire attacks.", "-"),
			new Skill("Resist Ice", 14, " Reduce damage from Ice attacks.", "-"),
			new Skill("Resist Elec", 14, " Reduce damage from Electric attacks.", "-"),
			new Skill("Resist Wind", 14, " Reduce damage from Wind attacks.", "-"),
			new Skill("Resist Psy", 14, " Reduce damage from Psy attacks.", "-"),
			new Skill("Resist Nuke", 14, " Reduce damage from Nuclear attacks.", "-"),
			new Skill("Resist Bless", 14, " Reduce damage from Bless attacks.", "-"),
			new Skill("Resist Curse", 14, " Reduce damage from Curse attacks.", "-"),
			new Skill("Null Bless/Curse&", 14, " Impart immunity against Bless and Curse attacks.", "-"),
			new Skill("Resist Dizzy", 14, " Reduce susceptibility to Dizzy.", "-"),
			new Skill("Resist Forget", 14, " Reduce susceptibility to Forget.", "-"),
			new Skill("Resist Sleep", 14, " Reduce susceptibility to Sleep.", "-"),
			new Skill("Resist Confuse", 14, " Reduce susceptibility to Confuse.", "-"),
			new Skill("Resist Fear", 14, " Reduce susceptibility to Fear.", "-"),
			new Skill("Resist Despair", 14, " Reduce susceptibility to Despair.", "-"),
			new Skill("Resist Rage", 14, " Reduce susceptibility to Rage.", "-"),
			new Skill("Resist Brainwash", 14, " Reduce susceptibility to Brainwash.", "-"),
			new Skill("Fortify Spirit", 14, " Reduce susceptibilities to all ailments.", "-"),
			new Skill("Null Phys", 14, " Impart immunity against Physical attacks.", "-"),
			new Skill("Null Fire", 14, " Impart immunity against Fire attacks.", "-"),
			new Skill("Null Ice", 14, " Impart immunity against Ice attacks.", "-"),
			new Skill("Null Elec", 14, " Impart immunity against Electric attacks.", "-"),
			new Skill("Null Wind", 14, " Impart immunity against Wind attacks.", "-"),
			new Skill("Null Psy", 14, " Impart immunity against Psy attacks.", "-"),
			new Skill("Null Nuke", 14, " Impart immunity against Nuclear attacks.", "-"),
			new Skill("Null Bless", 14, " Impart immunity against Bless attacks.", "-"),
			new Skill("Null Curse", 14, " Impart immunity against Curse attacks.", "-"),
			new Skill("Null Dizzy", 14, " Impart immunity against Dizzy.", "-"),
			new Skill("Null Forget", 14, " Impart immunity against Forget.", "-"),
			new Skill("Null Sleep", 14, " Impart immunity against Sleep.", "-"),
			new Skill("Null Confuse", 14, " Impart immunity against Confuse.", "-"),
			new Skill("Null Fear", 14, " Impart immunity against Fear.", "-"),
			new Skill("Null Despair", 14, " Impart immunity against Despair.", "-"),
			new Skill("Null Rage", 14, " Impart immunity against Rage.", "-"),
			new Skill("Null Brainwash", 14, " Impart immunity against Brainwash.", "-"),
			new Skill("Unshaken Will", 14, " Impart immunity against all mental ailments.", "-"),
			new Skill("Repel Phys", 14, " Repel Physical attacks.", "-"),
			new Skill("Repel Fire", 14, " Repel Fire attacks.", "-"),
			new Skill("Repel Ice", 14, " Repel Ice attacks.", "-"),
			new Skill("Repel Elec", 14, " Repel Electric attacks.", "-"),
			new Skill("Repel Wind", 14, " Repel Wind attacks.", "-"),
			new Skill("Repel Psy", 14, " Repel Psy attacks.", "-"),
			new Skill("Repel Nuke", 14, " Repel Nuclear attacks.", "-"),
			new Skill("Repel Bless", 14, " Repel Bless attacks.", "-"),
			new Skill("Repel Curse", 14, " Repel Curse attacks.", "-"),
			new Skill("Drain Phys", 14, " Absorb Physical attacks.", "-"),
			new Skill("Drain Fire", 14, " Absorb Fire attacks.", "-"),
			new Skill("Drain Ice", 14, " Absorb Ice attacks.", "-"),
			new Skill("Drain Elec", 14, " Absorb Electric attacks.", "-"),
			new Skill("Drain Wind", 14, " Absorb Wind attacks.", "-"),
			new Skill("Drain Psy", 14, " Absorb Psy attacks.", "-"),
			new Skill("Drain Nuke", 14, " Absorb Nuclear attacks.", "-"),
			new Skill("Drain Bless", 14, " Absorb Bless attacks.", "-"),
			new Skill("Drain Curse", 14, " Absorb Curse attacks.", "-"),
			new Skill("Sharp Student", 14, " Lower odds of receiving critical hit.", "-"),
			new Skill("Firm Stance", 14, " Half all incoming damage by sacrificing evasion completely.", "-"),
			new Skill("Brush of Vanity&", 14, " Nullifies wearer's weaknesses.", "-"),
			new Skill("Dodge Physical", 14, " Double evasion rate against Physical attacks.", "-"),
			new Skill("Dodge Fire", 14, " Double evasion rate against Fire attacks.", "-"),
			new Skill("Dodge Ice", 14, " Double evasion rate against Ice attacks.", "-"),
			new Skill("Dodge Elec", 14, " Double evasion rate against Electric attacks.", "-"),
			new Skill("Dodge Wind", 14, " Double evasion rate against Wind attacks.", "-"),
			new Skill("Dodge Psy", 14, " Double evasion rate against Psy attacks.", "-"),
			new Skill("Dodge Nuke", 14, " Double evasion rate against Nuclear attacks.", "-"),
			new Skill("Dodge Bless", 14, " Double evasion rate against (non instant death) Bless attacks.", "-"),
			new Skill("Dodge Curse", 14, " Double evasion rate against (non instant death) Curse attacks.", "-"),
			new Skill("Evade Physical", 14, " Triple evasion rate against Physical attacks.", "-"),
			new Skill("Evade Fire", 14, " Triple evasion rate against Fire attacks.", "-"),
			new Skill("Evade Ice", 14, " Triple evasion rate against Ice attacks.", "-"),
			new Skill("Evade Elec", 14, " Triple evasion rate against Electric attacks.", "-"),
			new Skill("Evade Wind", 14, " Triple evasion rate against Wind attacks.", "-"),
			new Skill("Evade Psy", 14, " Triple evasion rate against Psy attacks.", "-"),
			new Skill("Evade Nuke", 14, " Triple evasion rate against Nuclear attacks.", "-"),
			new Skill("Evade Bless", 14, " Triple evasion rate against (non instant death) Bless attacks.", "-"),
			new Skill("Evade Curse", 14, " Triple evasion rate against (non instant death) Curse attacks.", "-"),
			new Skill("Angelic Grace", 14, " Double evasion rate against all magical attacks except Hama/Mudo/Almighty.", "-"),
			new Skill("Climate Decorum", 14, " Double evasion against all attacks under rainy day or special weather warning.", "-"),
			new Skill("Ali Dance", 14, " Half hit rate of all incoming attacks.", "-"),
			new Skill("Last Stand", 14, " Greatly decreases Accuracy of all foesΓÇÖ attacks except Almighty when surrounded.", "-"),
			new Skill("Samurai Spirit&", 14, " Increases Evasion from Critical and magical attacks.", "-"),
			new Skill("Hide&", 14, " Decreases chance of being targeted by foes.", "-"),
			new Skill("Regenerate 1", 14, " Restore 2% of max HP each turn in battle.", "-"),
			new Skill("Regenerate 2", 14, " Recover 4% of max HP each turn in battle.", "-"),
			new Skill("Regenerate 3", 14, " Recover 6% of max HP each turn in battle.", "-"),
			new Skill("Invigorate 1", 14, " Recover 3 SP each turn in battle.", "-"),
			new Skill("Invigorate 2", 14, " Recover 5 SP each turn in battle.", "-"),
			new Skill("Invigorate 3", 14, " Recover 7 SP each turn in battle.", "-"),
			new Skill("Fast Heal", 14, " Half the time needed to recover from ailments.", "-"),
			new Skill("Insta-Heal", 14, " Recover from an ailment in 1 turn.", "-"),
			new Skill("Divine Grace", 14, " Effects of healing magic are increased by 50%.", "-"),
			new Skill("Soul Touch&", 14, " Recover 5 SP when performing Baton Pass.", "-"),
			new Skill("Soul Chain", 14, " Recover 20 SP when performing Baton Pass.", "-"),
			new Skill("Heat Up", 14, " Random chance to recover 5% HP and 10 SP.", "-"),
			new Skill("Holy Embrace", 14, " Recover 25% of max HP each turn in battle (Unique to Maria).", "-"),
			new Skill("Holy Whisper", 14, " Recover 15% max HP and SP each turn in battle (Unique to Maria).", "-"),
			new Skill("Life Bonus&", 14, " Increases max HP by 10%.", "-"),
			new Skill("Life Gain&", 14, " Increases max HP by 20%.", "-"),
			new Skill("Life Surge&", 14, " Increases max HP by 30%.", "-"),
			new Skill("Life Rise&", 14, " Increases max HP by 40%.", "-"),
			new Skill("Life Boost&", 14, " Increases max HP by 20.", "-"),
			new Skill("Mana Bonus&", 14, " Increases max SP by 10%.", "-"),
			new Skill("Mana Gain&", 14, " Increases max SP by 20%.", "-"),
			new Skill("Mana Surge&", 14, " Increases max SP by 30%.", "-"),
			new Skill("Attack Master", 14, " Automatic Tarukaja at the start of battle.", "-"),
			new Skill("Defense Master", 14, " Automatic Rakukaja at the start of battle.", "-"),
			new Skill("Speed Master", 14, " Automatic Sukukaja at the start of battle.", "-"),
			new Skill("Auto-Mataru", 14, " Automatic Matarukaja at the start of battle (Overwrites Attack Master).", "-"),
			new Skill("Auto-Maraku", 14, " Automatic Marakukaja at the start of battle (Overwrites Defense Master).", "-"),
			new Skill("Auto-Masuku", 14, " Automatic Masukukaja at the start of battle (Overwrites Speed Master).", "-"),
			new Skill("Heat Up", 14, " Recover 5% HP and 10 SP at the start of preemptive turn.", "-"),
			new Skill("Endure", 14, " Survive one fatal blow with 1 HP remaining.", "-"),
			new Skill("Survival Trick", 14, " Survive one instant death attack with 1 HP remaining.", "-"),
			new Skill("Enduring Soul", 14, " Survive one fatal blow with HP completely recovered.", "-"),
			new Skill("Growth 1", 14, " Persona gains 1/4 EXP while inactive.", "-"),
			new Skill("Growth 2", 14, " Persona gains 1/2 EXP while inactive.", "-"),
			new Skill("Growth 3", 14, " Persona gains full EXP even while inactive.", "-"),
			new Skill("Life Aid", 14, " Recover 8% HP and SP after victory.", "-"),
			new Skill("Victory Cry", 14, " Fully recover HP and SP after victory.", "-"),
			new Skill("Money Boost&", 14, " Party gains 15% more money after victory.", "-"),
			new Skill("+15% EXP&", 14, " Wearer gains 15% more EXP after victory.", "-"),
		}
	};

    private Trait[] traitList = new Trait[] {
			new Trait("Last Stand", "Allows use of ambush-only skills after Baton Pass."),
			new Trait("Heated Bloodline", " Reduce cost of Fire skills by 50%."),
			new Trait("Frigid Bloodline", " Reduce cost of Ice skills by 50%."),
			new Trait("Electric Bloodline", " Reduce cost of Elec skills by 50%."),
			new Trait("Wind Bloodline", " Reduce cost of Wind skills by 50%."),
			new Trait("Psychic Bloodline", " Reduce cost of Psy skills by 50%."),
			new Trait("Atomic Bloodline", " Reduce cost of Nuke skills by 50%."),
			new Trait("Blessed Bloodline", " Reduce cost of Bless skills by 50%."),
			new Trait("Cursed Bloodline", " Reduce cost of Curse skills by 50%."),
			new Trait("Savior Bloodline", " Reduce cost of Healing skills by 50%."),
			new Trait("Relief Bloodline", " Reduce cost of Support skills by 50%."),
			new Trait("Drunken Passion", " Reduce cost of Fire skills by 75%."),
			new Trait("Cocytus", " Reduce cost of Ice skills by 75%."),
			new Trait("Bargain Bolts", " Reduce cost of Elec skills by 75%."),
			new Trait("Vahana's Wings", " Reduce cost of Wind skills by 75%."),
			new Trait("Chi You's Blessing", " Reduce cost of Psy skills by 75%."),
			new Trait("Atomic Hellscape", " Reduce cost of Nuke skills by 75%."),
			new Trait("Martyr's Gift", " Reduce cost of Bless skills by 75%."),
			new Trait("Mother's Lament", " Reduce cost of Curse skills by 75%."),
			new Trait("Grace of Mother", " Reduce cost of Healing skills by 75%."),
			new Trait("Ave Maria", " Reduce cost of Support skills by 75%."),
			new Trait("Just Die", " Reduce cost of instant death skills to 0."),
			new Trait("Allure of Wisdom", " Reduce cost of magic skills by 75%."),
			new Trait("Thermal Conduct", " Increase chance of inflicting Burn after Baton Pass."),
			new Trait("Cold-Blooded", " Increase chance of inflicting Freeze during 1 More."),
			new Trait("Static Electricity", " Increase chance of inflicting Shock on downed foes."),
			new Trait("Foul Odor", " Increase chance of inflicting Ailments after Baton Pass."),
			new Trait("Ghost Nest", " Increase chance of inflicting Ailments on downed foes."),
			new Trait("Foul Stench", " Increase chance of inflicting Ailments."),
			new Trait("Striking Weight", " Strengthen Physical attacks by 20%."),
			new Trait("Undying Fury", " Strengthen Physical attacks by 30%."),
			new Trait("Intense Focus", " Strengthen single-target magic attacks by 20%."),
			new Trait("Mighty Gaze", " Strengthen multi-target magic attacks by 20%."),
			new Trait("Skillful Combo", " Increase Attack after Baton Pass."),
			new Trait("Linked Bloodline", " Greatly increase Attack after Baton Pass."),
			new Trait("Ailment Hunter", " Increases Attack by 25% per ailment inflicted on foe."),
			new Trait("Deathly Illness", " Increase success rate of Instant Death skills."),
			new Trait("Omen", " Greatly increase success rate of Instant Death skills."),
			new Trait("Skillful Technique", " Strengthen Technical damage by 25%."),
			new Trait("Universal Law", " Strengthen Technical damage by 50%."),
			new Trait("Relentless", " Increase Attack by 50% when striking foe's weakness."),
			new Trait("Retaliating Body", " Doubles Counter damage."),
			new Trait("Will of the Sword", " Triples Charge/Concentrate skill damage."),
			new Trait("Pagan Allure", " Strengthen magic attacks by 50%."),
			new Trait("Draining Mouth", " Doubles effect of Drain-type skills and passives."),
			new Trait("Gluttonmouth", " Increase amount of HP restored to self by 50%."),
			new Trait("Demon's Bite", " Doubles amount of HP restored to self."),
			new Trait("Mouth of Savoring", " Increase amount of SP restored to self by 50%."),
			new Trait("Naranari", " Doubles amount of SP restored to self."),
			new Trait("Internal Hypnosis", " Increase buff timers by 1 turn for self."),
			new Trait("Positive Thoughts", " Increase buff timers by 2 turns for self."),
			new Trait("Potent Hypnosis", " Increase buff timers by 1 turn for party."),
			new Trait("Wealth of Lotus", " Increase buff timers by 2 turns for party."),
			new Trait("Rare Antibody", " Reduce susceptibility to all ailments."),
			new Trait("Immunity", " Impart immunity against all ailments."),
			new Trait("Bloodstained Eyes", " Increase allies' evasion against foes inflicted with ailments."),
			new Trait("Crisis Control", " Decrease damage received when struck by weakness."),
			new Trait("Gloomy Child", " Activates all equipped special weather passives in normal weather."),
			new Trait("Pinch Anchor", " Allows use of ambush-only skills after Baton Pass."),
			new Trait("Vitality of the Tree", " Allows use of ambush-only skills under normal conditions."),
			new Trait("Circle of Sadness", " Revives with 1 HP when KO'd. Usable 4 times in battle", true),
			new Trait("Iron Heart", " Decreases SP cost by half after Baton Pass.", true),
			new Trait("Hallowed Spirit", " Doubles amount of HP/SP restored to self.", true),
			new Trait("God Maker", " Increases chance of triggering ally's Persona traits.", true),
			new Trait("Hollow Jester", " Increase Attack by 40% per ailment inflicted on foe.", true),
			new Trait("Inviolable Beauty", " Triples Counter damage.", true),
			new Trait("Tag Team", " Expendable items not used up after Baton Pass.", true),
			new Trait("Frenzied Bull", " Increases damage to foes when low on HP.", true),
			new Trait("Bolstering Force", " Increases Attack by 50% during 1 More.", true),
			new Trait("Grace of the Olive", " Decreases HP/SP cost to 0 during 1 More.", true),
			new Trait("Country Maker", " Increases Attack/Defense based on Inmate Registry completion.", true),
			new Trait("Hazy Presence", " Increases chance of triggering ally's Follow-Up attack.", true),
			new Trait("Treasured Talent", "Carries multiple traits to pass down during fusion.")
	};

    private ArrayList<Persona> listOfPersonas;

    //an arcana table useful for helping figure out the resulting fusion's arcana
    private Arcana[][] arcanaChart = new Arcana[][]{
        {Arcana.Fool, Arcana.Death, Arcana.Moon, Arcana.Hanged_Man, Arcana.Temperance, Arcana.Hermit, Arcana.Chariot, Arcana.Moon, Arcana.Star, Arcana.Priestess, Arcana.Faith, Arcana.Death, Arcana.Tower, Arcana.Strength, Arcana.Hierophant, Arcana.Temperance, Arcana.Empress, Arcana.Magician, Arcana.Justice, Arcana.Justice, Arcana.Sun, Arcana.Consultant, Arcana.Hierophant},
        {Arcana.Death, Arcana.Magician, Arcana.Temperance, Arcana.Justice, Arcana.Faith, Arcana.Death, Arcana.Devil, Arcana.Priestess, Arcana.Emperor, Arcana.Lovers, Arcana.Justice, Arcana.Fool, Arcana.Empress, Arcana.Hermit, Arcana.Chariot, Arcana.Hierophant, Arcana.Temperance, Arcana.Priestess, Arcana.Lovers, Arcana.Hierophant, Arcana.Strength, Arcana.Strength, Arcana.Moon},
        {Arcana.Moon, Arcana.Temperance, Arcana.Priestess, Arcana.Emperor, Arcana.Empress, Arcana.Magician, Arcana.Fortune, Arcana.Hierophant, Arcana.Death, Arcana.Temperance, Arcana.Magician, Arcana.Devil, Arcana.Death, Arcana.Magician, Arcana.Devil, Arcana.Moon, Arcana.Hanged_Man, Arcana.Hermit, Arcana.Hierophant, Arcana.Chariot, Arcana.Justice, Arcana.Justice, Arcana.Faith},
        {Arcana.Hanged_Man, Arcana.Justice, Arcana.Emperor, Arcana.Empress, Arcana.Justice, Arcana.Fool, Arcana.Judgement, Arcana.Star, Arcana.Lovers, Arcana.Strength, Arcana.Hermit, Arcana.Faith, Arcana.Priestess, Arcana.Fool, Arcana.Faith, Arcana.Sun, Arcana.Emperor, Arcana.Lovers, Arcana.Fortune, Arcana.Tower, Arcana.Emperor, Arcana.Magician, Arcana.Hanged_Man},
        {Arcana.Temperance, Arcana.Faith, Arcana.Empress, Arcana.Justice, Arcana.Emperor, Arcana.Fortune, Arcana.Fool, Arcana.Faith, Arcana.Chariot, Arcana.Hierophant, Arcana.Sun, Arcana.Tower, Arcana.Devil, Arcana.Hermit, Arcana.Devil, Arcana.Justice, Arcana.Star, Arcana.Lovers, Arcana.Tower, Arcana.Judgement, Arcana.Priestess, Arcana.Priestess, Arcana.Lovers},
        {Arcana.Hermit, Arcana.Death, Arcana.Magician, Arcana.Fool, Arcana.Fortune, Arcana.Hierophant, Arcana.Strength, Arcana.Star, Arcana.Hanged_Man, Arcana.Consultant, Arcana.Justice, Arcana.Fool, Arcana.Sun, Arcana.Chariot, Arcana.Death, Arcana.Hanged_Man, Arcana.Judgement, Arcana.Tower, Arcana.Priestess, Arcana.Lovers, Arcana.Faith, Arcana.Empress, Arcana.Justice},
        {Arcana.Chariot, Arcana.Devil, Arcana.Fortune, Arcana.Judgement, Arcana.Fool, Arcana.Strength, Arcana.Lovers, Arcana.Temperance, Arcana.Judgement, Arcana.Chariot, Arcana.Strength, Arcana.Death, Arcana.Consultant, Arcana.Temperance, Arcana.Strength, Arcana.Moon, Arcana.Empress, Arcana.Faith, Arcana.Magician, Arcana.Empress, Arcana.Hanged_Man, Arcana.Tower, Arcana.Tower},
        {Arcana.Moon, Arcana.Priestess, Arcana.Hierophant, Arcana.Star, Arcana.Faith, Arcana.Star, Arcana.Temperance, Arcana.Chariot, Arcana.Moon, Arcana.Devil, Arcana.Consultant, Arcana.Hermit, Arcana.Fool, Arcana.Devil, Arcana.Strength, Arcana.Temperance, Arcana.Fortune, Arcana.Moon, Arcana.Lovers, Arcana.Priestess, null, Arcana.Lovers, Arcana.Sun},
        {Arcana.Star, Arcana.Emperor, Arcana.Death, Arcana.Lovers, Arcana.Chariot, Arcana.Hanged_Man, Arcana.Judgement, Arcana.Moon, Arcana.Justice, Arcana.Magician, Arcana.Emperor, Arcana.Consultant, Arcana.Lovers, Arcana.Fool, Arcana.Emperor, Arcana.Fool, Arcana.Sun, Arcana.Empress, Arcana.Devil, Arcana.Hanged_Man, null, Arcana.Hanged_Man, Arcana.Emperor},
        {Arcana.Priestess, Arcana.Lovers, Arcana.Temperance, Arcana.Strength, Arcana.Hierophant, Arcana.Consultant, Arcana.Chariot, Arcana.Devil, Arcana.Magician, Arcana.Hermit, Arcana.Star, Arcana.Hierophant, Arcana.Star, Arcana.Strength, Arcana.Strength, Arcana.Priestess, Arcana.Judgement, Arcana.Strength, Arcana.Chariot, Arcana.Devil, Arcana.Emperor, Arcana.Judgement, Arcana.Faith},
        {Arcana.Faith, Arcana.Justice, Arcana.Magician, Arcana.Hermit, Arcana.Sun, Arcana.Justice, Arcana.Strength, Arcana.Consultant, Arcana.Emperor, Arcana.Star, Arcana.Fortune, Arcana.Faith, Arcana.Emperor, Arcana.Star, Arcana.Empress, Arcana.Hierophant, Arcana.Hanged_Man, Arcana.Devil, Arcana.Sun, Arcana.Star, Arcana.Tower, Arcana.Consultant, Arcana.Judgement},
        {Arcana.Death, Arcana.Fool, Arcana.Devil, Arcana.Faith, Arcana.Tower, Arcana.Fool, Arcana.Death, Arcana.Hermit, Arcana.Consultant, Arcana.Hierophant, Arcana.Faith, Arcana.Strength, Arcana.Temperance, Arcana.Hierophant, Arcana.Chariot, Arcana.Death, Arcana.Faith, Arcana.Moon, Arcana.Magician, Arcana.Moon, null, Arcana.Star, Arcana.Empress},
        {Arcana.Tower, Arcana.Empress, Arcana.Death, Arcana.Priestess, Arcana.Devil, Arcana.Sun, Arcana.Consultant, Arcana.Fool, Arcana.Lovers, Arcana.Star, Arcana.Emperor, Arcana.Temperance, Arcana.Hanged_Man, Arcana.Moon, Arcana.Death, Arcana.Fortune, Arcana.Hermit, Arcana.Justice, Arcana.Consultant, Arcana.Hierophant, Arcana.Star, Arcana.Devil, Arcana.Star},
        {Arcana.Strength, Arcana.Hermit, Arcana.Magician, Arcana.Fool, Arcana.Hermit, Arcana.Chariot, Arcana.Temperance, Arcana.Devil, Arcana.Fool, Arcana.Strength, Arcana.Star, Arcana.Hierophant, Arcana.Moon, Arcana.Death, Arcana.Hanged_Man, Arcana.Chariot, Arcana.Sun, Arcana.Consultant, Arcana.Hierophant, Arcana.Fortune, null, Arcana.Fool, Arcana.Magician},
        {Arcana.Hierophant, Arcana.Chariot, Arcana.Devil, Arcana.Faith, Arcana.Devil, Arcana.Death, Arcana.Strength, Arcana.Strength, Arcana.Emperor, Arcana.Strength, Arcana.Empress, Arcana.Chariot, Arcana.Death, Arcana.Hanged_Man, Arcana.Temperance, Arcana.Fool, Arcana.Fortune, Arcana.Sun, Arcana.Consultant, Arcana.Magician, Arcana.Hermit, Arcana.Hermit, Arcana.Fool},
        {Arcana.Temperance, Arcana.Hierophant, Arcana.Moon, Arcana.Sun, Arcana.Justice, Arcana.Hanged_Man, Arcana.Moon, Arcana.Temperance, Arcana.Fool, Arcana.Priestess, Arcana.Hierophant, Arcana.Death, Arcana.Fortune, Arcana.Chariot, Arcana.Fool, Arcana.Devil, Arcana.Magician, Arcana.Strength, Arcana.Chariot, Arcana.Hermit, Arcana.Lovers, Arcana.Chariot, Arcana.Chariot},
        {Arcana.Empress, Arcana.Temperance, Arcana.Hanged_Man, Arcana.Emperor, Arcana.Star, Arcana.Judgement, Arcana.Empress, Arcana.Fortune, Arcana.Sun, Arcana.Judgement, Arcana.Hanged_Man, Arcana.Faith, Arcana.Hermit, Arcana.Sun, Arcana.Fortune, Arcana.Magician, Arcana.Tower, Arcana.Consultant, Arcana.Hermit, Arcana.Emperor, Arcana.Moon, Arcana.Death, Arcana.Death},
        {Arcana.Magician, Arcana.Priestess, Arcana.Hermit, Arcana.Lovers, Arcana.Lovers, Arcana.Tower, Arcana.Faith, Arcana.Moon, Arcana.Empress, Arcana.Strength, Arcana.Devil, Arcana.Moon, Arcana.Justice, Arcana.Consultant, Arcana.Sun, Arcana.Strength, Arcana.Consultant, Arcana.Star, Arcana.Temperance, Arcana.Judgement, Arcana.Fortune, Arcana.Temperance, Arcana.Sun},
        {Arcana.Justice, Arcana.Lovers, Arcana.Hierophant, Arcana.Fortune, Arcana.Tower, Arcana.Priestess, Arcana.Magician, Arcana.Lovers, Arcana.Devil, Arcana.Chariot, Arcana.Sun, Arcana.Magician, Arcana.Consultant, Arcana.Hierophant, Arcana.Consultant, Arcana.Chariot, Arcana.Hermit, Arcana.Temperance, Arcana.Moon, Arcana.Empress, Arcana.Fool, Arcana.Sun, Arcana.Temperance},
        {Arcana.Justice, Arcana.Hierophant, Arcana.Chariot, Arcana.Tower, Arcana.Judgement, Arcana.Lovers, Arcana.Empress, Arcana.Priestess, Arcana.Hanged_Man, Arcana.Devil, Arcana.Star, Arcana.Moon, Arcana.Hierophant, Arcana.Fortune, Arcana.Magician, Arcana.Hermit, Arcana.Emperor, Arcana.Judgement, Arcana.Empress, Arcana.Sun, Arcana.Death, Arcana.Emperor, Arcana.Fortune},
        {Arcana.Sun, Arcana.Strength, Arcana.Justice, Arcana.Emperor, Arcana.Priestess, Arcana.Faith, Arcana.Hanged_Man, null, null, Arcana.Emperor, Arcana.Tower, null, Arcana.Star, null, Arcana.Hermit, Arcana.Lovers, Arcana.Moon, Arcana.Fortune, Arcana.Fool, Arcana.Death, Arcana.Judgement, Arcana.Fortune, Arcana.Devil},
        {Arcana.Consultant, Arcana.Strength, Arcana.Justice, Arcana.Magician, Arcana.Priestess, Arcana.Empress, Arcana.Tower, Arcana.Lovers, Arcana.Hanged_Man, Arcana.Judgement, Arcana.Consultant, Arcana.Star, Arcana.Devil, Arcana.Fool, Arcana.Hermit, Arcana.Chariot, Arcana.Death, Arcana.Temperance, Arcana.Sun, Arcana.Emperor, Arcana.Fortune, Arcana.Faith, Arcana.Priestess},
        {Arcana.Hierophant, Arcana.Moon, Arcana.Faith, Arcana.Hanged_Man, Arcana.Lovers, Arcana.Justice, Arcana.Tower, Arcana.Sun, Arcana.Emperor, Arcana.Faith, Arcana.Judgement, Arcana.Empress, Arcana.Star, Arcana.Magician, Arcana.Fool, Arcana.Chariot, Arcana.Death, Arcana.Sun, Arcana.Temperance, Arcana.Fortune, Arcana.Devil, Arcana.Priestess, Arcana.Consultant}
    };

    //the instance anyone using this class will use
    private static Compendium instance = new Compendium();
	private boolean initiaized;
    private Compendium() {
		listOfPersonas = new ArrayList<Persona>();
		arcanaChart = new Arcana[AMT_ARCANA][AMT_ARCANA];
		initiaized = false;
		//loadPersonas();
	}

    public static Compendium getInstance()
    { return instance; }

//    public void load(String dataFolder, String file) {
//		if (!initiaized) {
//			loadPersonas(dataFolder, file);
//			initiaized = true;
//		}
//	}

	public void load(InputStream fileStream)
	{
		if(!initiaized)
		{
			loadPersonas(fileStream);
			initiaized = true;
		}
	}

    private void loadPersonas(InputStream stream)
    {

//		String path = dataFolder;
//		System.out.println(path);
		Scanner fileReader = null;
        //read the file for persona data
        try {
            fileReader = new Scanner(stream);

            while(fileReader.hasNext()) {

				String line = fileReader.nextLine().trim();
				System.out.println("LINE: " + line);

				//?| is a delimiter in the data file
				String[] values = line.split(" \\?\\| ");

				Persona addition;

				if (values[0].equalsIgnoreCase("Persona")) {
					addition = makePersona(values);
				} else if (values[0].equalsIgnoreCase("AdvancedPersona")) {
					addition = makeAdvanced(values);
				} else {
					addition = makeTreasureDemon(values);
				}

				listOfPersonas.add(addition);
			}

        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i = 0; i < listOfPersonas.size(); i++)
		{
			System.out.println(listOfPersonas.get(i).getName());
		}
    }

    private Persona makePersona(String[] values)
	{
		String name = values[1];
		int lvl = Integer.parseInt(values[2]);
		Arcana arcana = Arcana.valueOf(values[3]);

		int[] stats = processStats(values[4]);
		Resistance[] resistances = processResistances(values[5]);
		SkillSlot[] skills = processSkills(values[6]);
		String item = values[7];
		String itemR = values[8];
		Trait trait = findTrait(values[9]);
		Type inherits = Type.valueOf(values[10]);

		boolean dlc = name.contains("*");

		return new Persona(arcana, name, lvl, stats, resistances,
				skills, item, itemR, trait, inherits, dlc);
	}

	private AdvancedPersona makeAdvanced(String[] values)
	{
		String name = values[1];
		int lvl = Integer.parseInt(values[2]);
		Arcana arcana = Arcana.valueOf(values[3]);

		int[] stats = processStats(values[4]);
		Resistance[] resistances = processResistances(values[5]);
		SkillSlot[] skills = processSkills(values[6]);
		String item = values[7];
		String itemR = values[8];
		Trait trait = findTrait(values[9]);
		Persona[] recipe = processRecipe( values[10]);
		Type inherits = Type.valueOf(values[11]);

		boolean dlc = name.contains("*");

		return new AdvancedPersona(arcana, name, lvl, stats, resistances, skills, item,
				itemR, trait, recipe, inherits, dlc);
	}

	private TreasureDemon makeTreasureDemon(String[] values)
	{
		String name = values[1];
		int lvl = Integer.parseInt(values[2]);
		Arcana arcana = Arcana.valueOf(values[3]);

		int[] stats = processStats(values[4]);
		Resistance[] resistances = processResistances(values[5]);
		SkillSlot[] skills = processSkills(values[6]);
		String item = values[7];
		String itemR = values[8];
		Trait[] traits = processTraits(values[9]);

		//the logic to process the tier-chart is the as processing the stats
		int[] tierChart = processStats(values[10]);

		Type inherits = Type.valueOf(values[11]);

		return new TreasureDemon(arcana, name, lvl, stats, resistances, skills, item,
				itemR, traits, tierChart, inherits);
	}

	private int[] processStats(String strStats)
	{
		String[] temp = strStats.split(",");
		int[] stats = new int[temp.length];

		for(int i = 0; i < temp.length; i++)
		{
			stats[i] = Integer.parseInt(temp[i]);
		}

		return stats;
	}

	private Resistance[] processResistances(String strRes)
	{
		String[] temp = strRes.split(",");
		Resistance[] resistances = new Resistance[temp.length];

		for(int i = 0; i < temp.length; i++)
		{
			resistances[i] = Resistance.valueOf(temp[i]);
		}

		return resistances;
	}

	/* Skill slots have syntax like:
	* 	Name1.lvl1,Name2.lvl2,Name3.lvl3,...,NameK.lvlK
	* */
	private SkillSlot[] processSkills(String strSkills)
	{
		String[] skillPairs = strSkills.split(",");
		SkillSlot[] skills = new SkillSlot[skillPairs.length];

		for(int i = 0; i < skillPairs.length; i++)
		{
			System.out.println(skillPairs[i]);
			//creates an array that contains {Name, lvl} as strings
			String[] temp = skillPairs[i].split("\\.");

			skills[i] = new SkillSlot( findSkill(temp[0]), Integer.parseInt(temp[1]));

		}

		return skills;
	}

	private Persona[] processRecipe(String strVal)
	{
		String[] temp = strVal.split(",");
		Persona[] personas = new Persona[temp.length];

		for(int i = 0; i < temp.length; i++)
		{
			personas[i] = findPersona(temp[i]);
		}

		return personas;
	}

	private Trait[] processTraits(String strTrts)
	{
		String[] temp = strTrts.split(",");
		Trait[] traits = new Trait[temp.length];

		for(int i = 0; i < temp.length; i++)
		{
			traits[i] = findTrait(temp[i]);
		}

		return traits;
	}

	public final Persona findPersona(String name)
	{
		for(int i = 0; i < listOfPersonas.size(); i++)
		{
			if(listOfPersonas.get(i).getName().equals(name))
			{
				return listOfPersonas.get(i);
			}
		}

		return null;
	}

    //a find skill for when we don't know the skill type
    public Skill findSkill(String name)
	{
		for(int i = 0; i < skillList.length; i++)
		{
			for(int j = 0; j < skillList[i].length; j++)
			{
				if(skillList[i][j].getName().equalsIgnoreCase(name))
					return skillList[i][j];
			}
		}
		return null;
	}

	//a find skill method used if we know the type
	public Skill findSkill(String name, int type)
	{
		for(int i = 0; i < skillList[type].length; i++)
		{
			if(skillList[type][i].getName().equalsIgnoreCase(name))
				return skillList[type][i];
		}

		//if the skill is not found
		return null;
	}

	private Trait findTrait(String name)
	{
		for (int i = 0; i < traitList.length; i++) {
			if(traitList[i].name.equalsIgnoreCase(name))
				return traitList[i];
		}

		return null;
	}

    private boolean isArcana(String str)
    {
        try {
            Arcana.valueOf(str);
            return true;
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
    }
}
