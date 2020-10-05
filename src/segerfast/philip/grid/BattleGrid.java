package segerfast.philip.grid;

import segerfast.philip.ship.*;

import java.util.*;

public class BattleGrid {

    private final int gridSize = 10;

    private final CellContent[/*row*/][/*column*/] grid;
    private String label;

    public BattleGrid(String label) {
        this.label = label;
        grid = new CellContent[gridSize][gridSize];
        resetGrid();
    }

    public void placeShipsRandom() {
        BattleShip battleShip = new BattleShip();
        Carrier carrier = new Carrier();
        Destroyer destroyer = new Destroyer();
        PatrolBoat patrolBoat = new PatrolBoat();
        Submarine submarine = new Submarine();

        //List<AbstractShip> ships = new ArrayList<AbstractShip>(Arrays.asList(carrier, battleShip, destroyer, submarine, patrolBoat));
        List<AbstractShip> ships = new ArrayList<AbstractShip>();
        ships.add(battleShip);
        ships.add(carrier);
        ships.add(destroyer);
        ships.add(patrolBoat);
        ships.add(submarine);

        Random rand = new Random();

        for(AbstractShip ship : ships) {
            boolean horizontal = rand.nextBoolean();
            boolean spotFound = false;
            boolean horizontalRowsOccupied = false;
            int shipSize = ship.getType().getSize();
            List<Integer> occupiedRows = new ArrayList<>();
            List<Integer> occupiedColumns = new ArrayList<>();

            System.out.println("Placing ship: " + ship.getType().getName());

            if(horizontal) {

                while(!spotFound) {

                    int randRow = getRandomRow(occupiedRows);
                    System.out.println("Row: " + randRow);

                    // håller reda på alla öppna luckor som finns på nuvarande rad. Innehåller start-index och hur många
                    // lediga platser det finns framför.
                    // <key: indexStart, value: freeSpacesAhead>
                    Map<Integer, Integer> availableSpaceRanges = new HashMap<>();

                    int streak = 0; // hur många öppna luckor efter varandra som finns.
                    int start = 0; // start-index för lucka.

                    // Kollar igenom den valda kolumnen hur många öppna "luckor" det finns och hur stora de är.
                    // Detta för att se om ett skepp passar i någon av dem.

                    // i den här for-loopen går jag igenom alla celler i en viss rad (randRow).
                    for (int col = 0; col < gridSize; col++) {
                        // om den nuvarande kolumnen är vatten, öka luck-räknaren med 1 (streak) och spara informationen
                        // i availableSpaceRanges.
                        if (grid[randRow][col] == CellContent.WATER) {
                            streak++;
                            availableSpaceRanges.put(start, streak);
                        } else {
                            // Om en lucka inte innehåller vatten så är den upptagen. Då sparas inget i map:en. Streaken
                            // återställs till noll och en ruta hoppas över (för att den är upptagen).
                            streak = 0;
                            start = (col + 1);
                        }
                    }

                    // Kollar om det nuvarande skeppet får plats i någon av luckorna och sparar luckorna i potentialShipSpots.
                    Map<Integer, Integer> potentialShipSpots = new HashMap<>();
                    availableSpaceRanges.forEach((startIndex, range) -> {
                        if (range >= shipSize) {
                            potentialShipSpots.put(startIndex, range);
                        }
                    });

                    // Om det inte finns några lediga platser på den här raden, kolla på en annan rad.
                    if (potentialShipSpots.size() == 0) {
                        occupiedRows.add(randRow);
                        continue;
                    }

                    // Väljer ut en slumpmässig lucka.
                    Integer[] potentialShipSpotsKeys = potentialShipSpots.keySet().toArray(new Integer[0]);
                    Integer randomStartIndex = potentialShipSpotsKeys[rand.nextInt(potentialShipSpots.size())];
                    Integer range = potentialShipSpots.get(randomStartIndex);

                    // System.out.printf("Random range selected (startIndex, range): (%s:%s)%n", randomStartIndex, range);

                    // Väljer ut en slumpmässig plats någonstans i ovanstående lucka.
                    int extraSpace = range - shipSize;
                    int randomIndex = ((extraSpace > 0 ? (rand.nextInt(extraSpace + 1)) : 0) + randomStartIndex);

                    // Placerar ut båten!
                    for (int i = 0; i < shipSize; i++) {
                        int col = randomIndex + i;

                        grid[randRow][col] = ship.shipFragments.get(i);
                    }

                    spotFound = true;
                }
            } else if(!horizontal) {

                while(!spotFound) {

                    int randCol = getRandomColumn(occupiedColumns);
                    System.out.println("Column: " + randCol);

                    // håller reda på alla öppna luckor som finns på nuvarande rad. Innehåller start-index och hur många
                    // lediga platser det finns framför.
                    // <key: indexStart, value: freeSpacesAhead>
                    Map<Integer, Integer> availableSpaceRanges = new HashMap<>();

                    int streak = 0;
                    int start = 0;

                    for (int row = 0; row < gridSize; row++) {
                        if (grid[row][randCol] == CellContent.WATER) {
                            streak++;
                            availableSpaceRanges.put(start, streak);
                        } else {
                            streak = 0;
                            start = (row + 1);
                        }
                    }

                    // Kollar om det nuvarande skeppet får plats i någon av luckorna och sparar luckorna i potentialShipSpots.
                    Map<Integer, Integer> potentialShipSpots = new HashMap<>();
                    availableSpaceRanges.forEach((startIndex, range) -> {
                        if (range >= shipSize) {
                            potentialShipSpots.put(startIndex, range);
                        }
                    });

                    // Om det inte finns några lediga platser på den här raden, kolla på en annan rad.
                    if (potentialShipSpots.size() == 0) {
                        occupiedRows.add(randCol);
                        continue;
                    }

                    // Väljer ut en slumpmässig lucka.
                    Integer[] potentialShipSpotsKeys = potentialShipSpots.keySet().toArray(new Integer[0]);
                    Integer randomStartIndex = potentialShipSpotsKeys[rand.nextInt(potentialShipSpots.size())];
                    Integer range = potentialShipSpots.get(randomStartIndex);

                    // Väljer ut en slumpmässig plats någonstans i ovanstående lucka.
                    int extraSpace = range - shipSize;
                    int randomIndex = ((extraSpace > 0 ? (rand.nextInt(extraSpace + 1)) : 0) + randomStartIndex);

                    // Placerar ut båten!
                    for (int i = 0; i < shipSize; i++) {
                        int row = randomIndex + i;

                        grid[row][randCol] = ship.shipFragments.get(i);
                    }

                    spotFound = true;
                }
            }
        }

        printGrid();

    }

    private int getRandomRow(List<Integer> excludeRows) {
        Random rand = new Random();
        Math.random();
        int range = gridSize;

        int random = rand.nextInt(range);
        while(excludeRows.contains(random)) {
            random = rand.nextInt(range);
        }

        return random;
    }

    private int getRandomColumn(List<Integer> excludeColumns) {
        Random rand = new Random();
        Math.random();
        int range = gridSize;

        int random = rand.nextInt(range);
        while(excludeColumns.contains(random)) {
            random = rand.nextInt(range);
        }

        return random;
    }

    // Fills the entire grid with water.
    public void resetGrid() {
        for(int i = 0; i < gridSize; i++) {
            for(int j = 0; j < gridSize; j++) {
                grid[i][j] = CellContent.WATER;
            }
        }
    }

    public void printGrid() {
        if(grid == null) {
            System.out.println("Cannot print grid because it's null.");
            return;
        }

        for(CellContent[] row : grid) {
            for(CellContent column : row) {
                System.out.print(column.getSymbol() + "  ");
            }
            System.out.println();
        }
    }



    public String getLabel() {
        return label;
    }

    public int getGridSize() {
        return gridSize;
    }

}
