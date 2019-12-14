import { FoodItem } from "src/app/food/item-info/food-item";

export interface Cart{
    cartItems:FoodItem[];
    total: number;
};