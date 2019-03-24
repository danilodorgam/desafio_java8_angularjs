import componente from './telefone.component';
import EnumService from "../../services/EnumService";

export default angular.module(
        'telefoneComponent', [
        EnumService.name
    ])
    .component('telefoneComponent', componente);