MyModName

Version: 1.0.0
Minecraft Version: 1.21.1

A Minecraft mod adding new ores, unique variants, and custom entities to enhance your world exploration and gameplay experience.

Features
Custom Ores

Four new ores with multiple variants:

Memoite Ore and Sapphire Deepslate variants along with regular stone variants

Ruby Ore found only in the Nether and Opal ore only found in the End.

Ores spawn naturally in the world, making exploration rewarding.

Each ore has unique characteristics and can be used in crafting, building, or smelting.

Custom Entities

Two custom entities with unique behaviors (describe briefly what they do if you want).
Watcher one that watches you if you get to close something might happen :)

Steps Entity makes sounds and chases you.

Adds new interactions and challenges in your world.

Additional Features

Make sure you have Minecraft Forge installed.

Launch Minecraft with the Forge 1.21.1.

Usage

Explore the world to find and mine new ores.

Encounter custom entities in various biomes.

Beware of what may lurk in the dark.

Use the ores in your crafting recipes and builds.

Planned Updates

Additional ores and variants

More custom entities with unique abilities

Advanced crafting mechanics

Source installation information for modders
-------------------------------------------
This code follows the Minecraft Forge installation methodology. It will apply
some small patches to the vanilla MCP source code, giving you and it access 
to some of the data and functions you need to build a successful mod.

Note also that the patches are built against "un-renamed" MCP source code (aka
SRG Names) - this means that you will not be able to read them directly against
normal code.

Setup Process:
==============================

Step 1: Open your command-line and browse to the folder where you extracted the zip file.

Step 2: You're left with a choice.
If you prefer to use Eclipse:
1. Run the following command: `./gradlew genEclipseRuns`
2. Open Eclipse, Import > Existing Gradle Project > Select Folder 
   or run `gradlew eclipse` to generate the project.

If you prefer to use IntelliJ:
1. Open IDEA, and import project.
2. Select your build.gradle file and have it import.
3. Run the following command: `./gradlew genIntellijRuns`
4. Refresh the Gradle Project in IDEA if required.

If at any point you are missing libraries in your IDE, or you've run into problems you can 
run `gradlew --refresh-dependencies` to refresh the local cache. `gradlew clean` to reset everything 
(this does not affect your code) and then start the process again.

Mapping Names:
=============================
By default, the MDK is configured to use the official mapping names from Mojang for methods and fields 
in the Minecraft codebase. These names are covered by a specific license. All modders should be aware of this
license, if you do not agree with it you can change your mapping names to other crowdsourced names in your 
build.gradle. For the latest license text, refer to the mapping file itself, or the reference copy here:
https://github.com/MinecraftForge/MCPConfig/blob/master/Mojang.md

Additional Resources: 
=========================
Community Documentation: https://docs.minecraftforge.net/en/latest/gettingstarted/
LexManos' Install Video: https://youtu.be/8VEdtQLuLO0
Forge Forums: https://forums.minecraftforge.net/
Forge Discord: https://discord.minecraftforge.net/
