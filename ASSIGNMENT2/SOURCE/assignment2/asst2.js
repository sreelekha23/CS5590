(function() {
    var app = angular.module('ticTacToeApp', []);
    app.controller('ticTacToeCtrl', function() {
        var vm = this;
        var emptyCell = '?';

        vm.board = [
            [ { value: emptyCell }, { value: emptyCell }, { value: emptyCell } ],
            [ { value: emptyCell }, { value: emptyCell }, { value: emptyCell } ],
            [ { value: emptyCell }, { value: emptyCell }, { value: emptyCell } ]
        ];

        vm.reset = function() {
            vm.board.forEach(function(row) {
                row.forEach(function(cell) {
                    cell.value = emptyCell;
                });
            });
            vm.currentPlayer = 'X';
            vm.winner = false;
            vm.cat = false;
        };

        vm.reset();

        vm.isTaken = function(cell) {
            return cell.value !== emptyCell;
        };

        function checkForMatch(cell1, cell2, cell3) {
            // TODO: return true of cell1, cell2, and cell3 are the same and are not the emptyCell.
        }

        function isBoardFull() {
            // TODO: return true if the board is full (no emptyCell values).
        }

        function checkForEndOfGame() {
            // TODO: update the booleans vm.winner and vm.cat

            return vm.winner || vm.cat;
        }

        vm.move = function(cell) {
            cell.value = vm.currentPlayer;
            if (checkForEndOfGame() === false) {
                vm.currentPlayer = vm.currentPlayer === 'X' ? 'O' : 'X';
            }
        };
    });
})();