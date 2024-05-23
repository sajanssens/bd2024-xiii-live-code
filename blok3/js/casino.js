// @ts-check
class Person {

    /**
     * @param {string} name
     */
    constructor(name) {
        this._name = name;
    }
}

class Player extends Person {
    /**
     *
     * @param {string} name
     * @param {number} chips
     */
    constructor(name, chips) {
        super(name);
        this.chips = chips;
    }

    toString() {
        return `${this._name} has ${this.chips} number of chips left`;
    }
}

var playerOne = new Player('Han', 46);
var playerTwo = new Player('Leia', 68);

var highestNumberOfChips = Math.max(playerOne.chips, playerTwo.chips);
console.log(highestNumberOfChips + ' is the highest number of chips');

class RouletteBoard {
    constructor() {
        this.betRecords = [];
    }

    /**
     *
     * @param {Player} player
     * @param {number} bet
     */
    placeBet(player, bet) {
        var record = this.betRecords.find((r) => r.player === player && r.bet === bet);
        if (!record) {
            record = {player: player, bet: bet, numberOfChips: 0};
            this.betRecords.push(record);
        }
        record.numberOfChips++;
    }

    play() {
        var winner = Math.floor(Math.random() * 36);
        console.log('winning number: ' + winner);
        for (var record in this.betRecords) {
            if (this.betRecords[record].bet === winner) {
                var loot = this.betRecords[record].numberOfChips * 10;
                this.betRecords[record].player.chips += loot;
                console.log(
                    this.betRecords[record].player.toString() + ' wins ' + loot,
                );
            }
        }
        this.betRecords = [];
    }
}

var roulette = new RouletteBoard();
roulette.placeBet(playerOne, 20);
roulette.placeBet(playerOne, 20);
roulette.placeBet(playerTwo, 1);
roulette.placeBet(playerTwo, 2);
roulette.placeBet(playerTwo, 6);
roulette.placeBet(playerTwo, 31);
roulette.placeBet(playerTwo, 5);
roulette.placeBet(playerTwo, 4);

roulette.play();
