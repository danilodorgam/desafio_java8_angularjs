import StringMask from 'string-mask'

var patterns = {
    eightSimple: new StringMask('0000-0000'),
    nineSimple: new StringMask('00000-0000'),
    eight: new StringMask('(00) 0000-0000'),
    nine: new StringMask('(00) 00000-0000'),
    t0800: new StringMask('0000-000-0000'),
};


function phonebr() {
    return function (cleanValue) {
        var formattedValue = '';
        cleanValue = String(cleanValue);
        if (cleanValue.indexOf('0800') === 0) {
            formattedValue = patterns.t0800.apply(cleanValue);
        } else if (cleanValue.length < 9) {
            formattedValue = patterns.eightSimple.apply(cleanValue) || '';
        } else if (cleanValue.length < 10) {
            formattedValue = patterns.nineSimple.apply(cleanValue);
        } else if (cleanValue.length < 11) {
            formattedValue = patterns.eight.apply(cleanValue);
        } else {
            formattedValue = patterns.nine.apply(cleanValue);
        }

        return String(formattedValue).trim().replace(/[^0-9]$/, '');
    };
}

export default phonebr;