'use strict';


function Truncate() {
    return function(input, limit) {
        if (input) {
            if (limit > input.length) {
                return input.slice(0, limit);
            } else {
                return input.slice(0, limit) + '...';
            }
        }
    };
}

export default Truncate;