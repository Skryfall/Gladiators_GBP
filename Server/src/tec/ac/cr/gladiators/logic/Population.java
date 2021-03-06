package tec.ac.cr.gladiators.logic;
import java.util.Random;


public class Population {

    int popSize = 100;
    private Gladiators[] individuals = new Gladiators[100];
    private int fittest = 0;


    /**
     * Initialize population with size 100
     */
    public void initializePopulation() {
        for (int i = 0; i < individuals.length; i++) {
            individuals[i] = Gladiators.addGladiator(i);
        }
    }

    //Get random Gladiator

    /**
     * Choose a random Gladiator from the population
     * @return Gladiator
     */
    public  Gladiators getRandomGladiator(){
        Random rn = new Random();
        //Select a random crossover point
        int randomIndex = rn.nextInt(this.individuals.length);

        if(individuals[randomIndex] != this.getFittest()){
            return individuals[randomIndex];
        }else{
            return this.getRandomGladiator();
        }
    }

    /**
     * Get the best gladiator of the population
     * @return Gladiator
     */
    public Gladiators getFittest() {
        int maxFit = 0;
        int maxFitIndex = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (maxFit <= individuals[i].getFitness()) {
                maxFit = individuals[i].getFitness();
                maxFitIndex = i;
            }
        }
        this.fittest = individuals[maxFitIndex].getFitness();
        return individuals[maxFitIndex];
    }

    /**
     * Get the second best gladiator of the population
     * @return Gladiator
     */
    public Gladiators getSecondFittest() {
        int maxFit1 = 0;
        int maxFit2 = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (individuals[i].getFitness() > individuals[maxFit1].getFitness()) {
                maxFit2 = maxFit1;
                maxFit1 = i;
            } else if (individuals[i].getFitness() > individuals[maxFit2].getFitness()) {
                maxFit2 = i;
            }
        }
        return individuals[maxFit2];
    }

    /**
     * Get the worst gladiator of the population
     * @return Gladiator
     */
    public int getLeastFittestIndex() {
        int minFitVal = Integer.MAX_VALUE;
        int minFitIndex = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (minFitVal >= individuals[i].getFitness()) {
                minFitVal = individuals[i].getFitness();
                minFitIndex = i;
            }
        }
        return minFitIndex;
    }

    /**
     * Calculate fitness of each individual
     */
    public void calculateFitness() {

        for (int i = 0; i < individuals.length; i++) {
            individuals[i].calcFitness();
        }
        getFittest();
        getSecondFittest();

    }

    public void setFittest(int fittest) {
        this.fittest = fittest;
    }

    public int getFittestValue(){
        return  this.fittest;
    }

    public Gladiators[] getIndividuals() {
        return individuals;
    }

    public void setIndividuals(Gladiators[] individuals) {
        this.individuals = individuals;
    }
}