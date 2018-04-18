(function () {

    'use strict';

    angular
        .module('forum')
        .config(Config);

    Config.$inject = [
        '$stateProvider',
        '$urlRouterProvider',
        '$locationProvider'
    ];

    function Config($stateProvider,
                    $urlRouterProvider,
                    $locationProvider) {

        $stateProvider
            .state('main', {
                abstract: true
            })
            .state('login', {
                url: '/login',
                parent: 'main',
                templateUrl: './components/login/views/login.view.html',
                controller: 'ForumLoginController as LoginController',
                params: {
                    isLogin: true
                }
            })

    }

})();