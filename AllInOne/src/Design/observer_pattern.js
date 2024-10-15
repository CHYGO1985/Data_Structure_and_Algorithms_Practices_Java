// Subject (WeatherStation)
class WeatherStation {
  constructor() {
      this.observers = []; // List of observers (devices)
      this.temperature = null; // Current temperature
  }

  // Method to register (add) an observer
  addObserver(observer) {
      this.observers.push(observer);
  }

  // Method to unregister (remove) an observer
  removeObserver(observer) {
      this.observers = this.observers.filter((obs) => obs !== observer);
  }

  // Notify all observers about a change
  notifyObservers() {
      this.observers.forEach((observer) => observer.update(this.temperature));
  }

  // Set a new temperature and notify observers
  setTemperature(temp) {
      console.log(`WeatherStation: New temperature set to ${temp}°C`);
      this.temperature = temp;
      this.notifyObservers(); // Notify all observers
  }
}

// Observer interface
class Observer {
  update(temperature) {
      // To be implemented by concrete observers
  }
}

// Concrete Observer 1: Phone App
class PhoneApp extends Observer {
  update(temperature) {
      console.log(`PhoneApp: The temperature is now ${temperature}°C`);
  }
}

// Concrete Observer 2: Weather Website
class WeatherWebsite extends Observer {
  update(temperature) {
      console.log(`WeatherWebsite: Displaying new temperature: ${temperature}°C`);
  }
}

// Usage Example

// Create a WeatherStation (subject)
const weatherStation = new WeatherStation();

// Create observers (devices)
const phoneApp = new PhoneApp();
const weatherWebsite = new WeatherWebsite();

// Register observers with the weather station
weatherStation.addObserver(phoneApp);
weatherStation.addObserver(weatherWebsite);

// Simulate changing the temperature
weatherStation.setTemperature(25); // Notify both observers
// Output:
// WeatherStation: New temperature set to 25°C
// PhoneApp: The temperature is now 25°C
// WeatherWebsite: Displaying new temperature: 25°C

// Unregister an observer (phone app)
weatherStation.removeObserver(phoneApp);

// Change temperature again
weatherStation.setTemperature(30); // Only the weather website will be notified
// Output:
// WeatherStation: New temperature set to 30°C
// WeatherWebsite: Displaying new temperature: 30°C
