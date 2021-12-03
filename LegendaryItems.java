package dnDCharacterCreator;

public class LegendaryItems<I,N> {
	I items;
	N numbers;
	
	LegendaryItems(I items, N numbers) {
		this.items = items;
		this.numbers = numbers;
	}
	
	@SuppressWarnings("unchecked")
	public <I> I returnItem(){
		return (I) items;
	}
	
	@SuppressWarnings("unchecked")
	public <N> N returnItemNumber() {
		return (N) numbers;
	}
}
