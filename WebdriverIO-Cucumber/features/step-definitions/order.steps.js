const { Given, When, Then } = require('@wdio/cucumber-framework');

const MenuPage = require('../pageobjects/menu.page');

Given(/^I am on the menu page$/, async () => {
    await MenuPage.open();
    await browser.pause(1000);
});

When(/^I click ADD TO ORDER button$/, async () => {
    await MenuPage.btnAddOrder.click();
    await browser.pause(1000);
});

Then(/^I should see a pop up menu with an item added to the cart$/, async () => {
    const orderName = await $('span[class=orderName]');
    await expect(orderName).toExist();
});