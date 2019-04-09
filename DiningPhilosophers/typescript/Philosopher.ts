enum PhilosopherStates {
  "EATING",
  "HUNGRY",
  "THINKING"
}
enum Commands {
  "EAT",
  "END",
  "EXIT"
}
class Philosopher {
  state: PhilosopherStates;
  alreadyInQueue: boolean;
  constructor() {
    this.state = PhilosopherStates.THINKING;
    this.alreadyInQueue = false;
  }
}
export { Philosopher, PhilosopherStates };
