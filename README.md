# Ligero
Ligero is an app which is used to control analog LED Strips (in this case SMD 5050) or any other LED strip that uses analog RGB input.
It is used in conjunction with an HTTP based server which is running on Raspberry Pi.

## Working
The user selects the desired color for specific LED and the app sends an HTTP request to the server and then it changes it's color.

## Customization
You can manually add or remove the number of LEDs the app controls. Follow the following steps to do the same:

- Add or remove Fragments in  ``` ui.main.ledFragments``` package
- Edit ``` SectionsPagerAdapter.java``` 
	* Number of fragments to be shown and their titles
	* Instantiate required Fragments
- Implement color picker and the logic of HTTP request in desired fragments (you may use the pre-existing code or develop your own logic)

## Acknowledgements 
-  Color picker by [@LarsWerkman](https://github.com/LarsWerkman/HoloColorPicker)
