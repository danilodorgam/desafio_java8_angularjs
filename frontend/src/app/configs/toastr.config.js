'use strict';

function toastrConfig(toastrConfig) {
    angular.extend(toastrConfig, {
        allowHtml: false,
        closeButton: false,
        preventOpenDuplicates: true,
        iconClasses: {
            error: 'toast-error',
            info: 'toast-info',
            success: 'toast-success',
            warning: 'toast-warning'
        },
        messageClass: 'toast-message',
        onHidden: null,
        onShown: null,
        onTap: null,
        progressBar: true,
        tapToDismiss: false,
        templates: {
            toast: 'directives/toast/toast.html',
            progressbar: 'directives/progressbar/progressbar.html'
        },
        timeOut: 5000,
        titleClass: 'toast-title',
        toastClass: 'toast'
    });
}

toastrConfig.$inject = ['toastrConfig']

angular.module(process.env.APP_NAME).config(toastrConfig);