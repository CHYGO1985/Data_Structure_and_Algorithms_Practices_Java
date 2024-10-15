// Strategy Interface
class PaymentStrategy {
  pay(amount) {
    throw new Error('pay method must be implemented');
  }
}

// Concrete Strategy 1: Credit Card Payment
class CreditCardPayment extends PaymentStrategy {
  constructor(cardNumber) {
    super();
    this.cardNumber = cardNumber;
  }

  pay(amount) {
    console.log(
      `Paid $${amount} using Credit Card (Card Number: ${this.cardNumber})`
    );
  }
}

// Concrete Strategy 2: PayPal Payment
class PayPalPayment extends PaymentStrategy {
  constructor(email) {
    super();
    this.email = email;
  }

  pay(amount) {
    console.log(`Paid $${amount} using PayPal (Email: ${this.email})`);
  }
}

// Concrete Strategy 3: Cryptocurrency Payment
class CryptoPayment extends PaymentStrategy {
  constructor(walletAddress) {
    super();
    this.walletAddress = walletAddress;
  }

  pay(amount) {
    console.log(
      `Paid $${amount} using Cryptocurrency (Wallet Address: ${this.walletAddress})`
    );
  }
}

// Context: Payment Processor
class PaymentProcessor {
  setPaymentStrategy(paymentStrategy) {
    this.paymentStrategy = paymentStrategy;
  }

  processPayment(amount) {
    if (!this.paymentStrategy) {
      throw new Error('Payment strategy not selected');
    }
    this.paymentStrategy.pay(amount);
  }
}

// Usage Example

// Create a payment processor (context)
const paymentProcessor = new PaymentProcessor();

// Use Credit Card Payment Strategy
const creditCardPayment = new CreditCardPayment('1234-5678-9876-5432');
paymentProcessor.setPaymentStrategy(creditCardPayment);
paymentProcessor.processPayment(100); // Output: Paid $100 using Credit Card (Card Number: 1234-5678-9876-5432)

// Use PayPal Payment Strategy
const paypalPayment = new PayPalPayment('user@example.com');
paymentProcessor.setPaymentStrategy(paypalPayment);
paymentProcessor.processPayment(200); // Output: Paid $200 using PayPal (Email: user@example.com)

// Use Cryptocurrency Payment Strategy
const cryptoPayment = new CryptoPayment('0x123ABC456DEF789');
paymentProcessor.setPaymentStrategy(cryptoPayment);
paymentProcessor.processPayment(300); // Output: Paid $300 using Cryptocurrency (Wallet Address: 0x123ABC456DEF789)
