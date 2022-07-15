const { Given, When, Then } = require('@wdio/cucumber-framework');

const MenuPage = require('../pageobjects/menu.page');

Given(/^I am on the menu page$/, async () => {
    await MenuPage.open();
    await browser.pause(1000);
});

When(/^I click SORT BY, pick LIKES and click APPLY FILTERS$/, async () => {
    await MenuPage.sorting.click();
    await MenuPage.sorting_1.click();
    await browser.pause(1000);
    await MenuPage.btnSubmitOrder.click();
    await browser.pause(1000);
});

Then(/^I should see a list of items sorted by likes$/, async () => {
    const first = await $('app-own-menu-card-details>div:nth-child(2)>h3');
    await expect(first).toHaveText('BEER');
});