class Customer {
	constructor() {
		this.identity = ko.observable("");
		this.fullname = ko.observable("");
		this.email = ko.observable("");
		this.birthYear = ko.observable("");
		this.accounts = ko.observableArray([]);
	}
	update = (cust) => {
		for (let prop in cust)
			if (this.hasOwnProperty(prop))
				this[prop](cust[prop]);
	}
}

class Transfer {
	constructor() {
		this.fromIdentity = ko.observable();
		this.fromAccounts = ko.observableArray([]);
		this.fromAccount = ko.observable();
		this.toIdentity = ko.observable();
		this.toAccount = ko.observable();
		this.toAccounts = ko.observableArray([]);
		this.amount = ko.observable();
	}
	toJson = () => {
		return JSON.stringify({
			fromIdentity: this.fromIdentity(),
			fromIban: this.fromAccount().iban,
			toIdentity: this.toIdentity(),
			toIban: this.toAccount().iban,
			amount: this.amount() 
		});
	}
}

class BankingViewModel {
	constructor() {
		this.customer = new Customer();
		this.transfer = new Transfer();
	}

	find = async () => {
		let customer = await this.findCustomer(this.customer.identity());
		this.customer.update(customer);
	}

	findFromCustomer = async () => {
		let customer = await this.findCustomer(this.transfer.fromIdentity());
		this.transfer.fromAccounts(customer.accounts);
	}

	findToCustomer = async () => {
		let customer = await this.findCustomer(this.transfer.toIdentity());
		this.transfer.toAccounts(customer.accounts);
	}

	
    findCustomer = async (identity) => {
		return await fetch(`${AppConfig.url}/customers/${identity}`, {
				headers: {
					"Accept": "application/json"
				}
			}).then(res => res.json());
    }
    
	transferMoney = () => {
		fetch(`${AppConfig.url}/bank`, {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
				"Accept": "application/json"
			},
			body: this.transfer.toJson()
		})
			.then(res => res.json())
			.then(result => {
				console.log(result);
			});
	}
}

let bankingViewModel = new BankingViewModel();

window.onload = () => {
	ko.applyBindings(bankingViewModel);
}