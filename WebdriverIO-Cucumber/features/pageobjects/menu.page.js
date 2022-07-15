const Page = require('./page');

class MenuPage extends Page {

    get sorting () {
        return $('#mat-select-0');
    }

    get sorting_1 () {
        return $('#mat-option-1');
    }

    get btnSubmitOrder () {
        return $('button[type=submit]');
    }

    get btnAddOrder () {
        return $('span[class=order]');
    }

    get searchBar () {
        return $('#mat-input-1');
    }
    
    open () {
        return super.open('menu');
    }
}

module.exports = new MenuPage();