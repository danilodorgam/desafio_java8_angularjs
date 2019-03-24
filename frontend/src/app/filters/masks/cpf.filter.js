import StringMask from 'string-mask'

var cpf = new StringMask('000.000.000-00');

function CpfFilter() {
    return function(input){
        input = input.replace(/[^\d]/g, '').slice(0, 11);

        var formatedValue;

        formatedValue = cpf.apply(input);

        return String(formatedValue).trim().replace(/[^0-9]$/, '');
    };
}

export default CpfFilter;