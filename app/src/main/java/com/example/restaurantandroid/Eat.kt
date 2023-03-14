package com.example.restaurantandroid

sealed class Eat(var route: String?, var icon: Int?, var title: String?, var price: Int?) {
    class Food {
        class ColdSnacks {
            object Line : Eat("lineCategory", R.drawable.line, "Холодные закуски", null)
            class Fish {
                object Line : Eat("lineSubcategory", R.drawable.line, "Рыбные", null)
                object ColdFishSnack1 :
                    Eat("cold_fish_snack1", R.drawable.cold_fish_snack1, "Cold_snack1", 700)

                object ColdFishSnack2 :
                    Eat("cold_fish_snack2", R.drawable.cold_fish_snack2, "Cold_snack2", 650)

                object ColdFishSnack3 :
                    Eat("cold_fish_snack3", R.drawable.cold_fish_snack3, "Cold_snack3", 800)

                object ColdFishSnack4 :
                    Eat("cold_fish_snack4", R.drawable.cold_fish_snack4, "Cold_snack4", 780)

                var item = mutableListOf(
                    Line,
                    ColdFishSnack1,
                    ColdFishSnack2,
                    ColdFishSnack3,
                    ColdFishSnack4
                )

            }

            class Meat {
                object Line : Eat("lineSubcategory", R.drawable.line, "Мясные", null)
                object ColdMeatSnack1 :
                    Eat("cold_meat_snack1", R.drawable.cold_meat_snack1, "Cold_meat_snack1", 700)

                object ColdMeatSnack2 :
                    Eat("cold_meat_snack2", R.drawable.cold_meat_snack2, "Cold_meat_snack2", 700)

                object ColdMeatSnack3 :
                    Eat("cold_meat_snack3", R.drawable.cold_meat_snack3, "Cold_meat_snack3", 700)

                object ColdMeatSnack4 :
                    Eat("cold_meat_snack4", R.drawable.cold_meat_snack4, "Cold_meat_snack4", 700)

                var item = mutableListOf(
                    Line,
                    ColdMeatSnack1,
                    ColdMeatSnack2,
                    ColdMeatSnack3,
                    ColdMeatSnack4
                )
            }

            class Vegetables {
                object Line : Eat("lineSubcategory", R.drawable.line, "Овощные", null)
                object ColdVegSnack1 :
                    Eat("cold_veg_snack1", R.drawable.cold_veg_snack1, "Cold_veg_snack1", 700)

                object ColdVegSnack2 :
                    Eat("cold_veg_snack2", R.drawable.cold_veg_snack2, "Cold_veg_snack2", 700)

                object ColdVegSnack3 :
                    Eat("cold_veg_snack3", R.drawable.cold_veg_snack3, "Cold_veg_snack3", 700)

                var item = mutableListOf(
                    Line,
                    ColdVegSnack1,
                    ColdVegSnack2,
                    ColdVegSnack3
                )
            }

            var coldSnacks = mutableListOf<Eat>(Line).plus(Fish().item.plus(Meat().item.plus(Vegetables().item)))
        }

        class Salads {
            object Line : Eat("lineCategory", R.drawable.line, "Салаты", null)

            class Fish {
                object Line : Eat("lineSubcategory", R.drawable.line, "Рыбные", null)
                object SaladFish1 : Eat("salad_fish1", R.drawable.salads_fish1, "Salad_fish1", 700)
                object SaladFish2 : Eat("salad_fish2", R.drawable.salads_fish2, "Salad_fish2", 700)
                object SaladFish3 : Eat("salad_fish3", R.drawable.salads_fish3, "Salad_fish3", 700)
                object SaladFish4 : Eat("salad_fish4", R.drawable.salads_fish4, "Salad_fish4", 700)

                var item = mutableListOf(
                    Line,
                    SaladFish1,
                    SaladFish2,
                    SaladFish3,
                    SaladFish4,
                )
            }

            class Meat {
                object Line : Eat("lineSubcategory", R.drawable.line, "Мясные", null)
                object SaladMeat1 : Eat("salad_meat1", R.drawable.salads_fish1, "Salad_meat1", 700)
                object SaladMeat2 : Eat("salad_meat2", R.drawable.salads_fish2, "Salad_meat2", 700)
                object SaladMeat3 : Eat("salad_meat3", R.drawable.salads_fish3, "Salad_meat3", 700)
                object SaladMeat4 : Eat("salad_meat4", R.drawable.salads_fish4, "Salad_meat4", 700)

                var item = mutableListOf(
                    Line,
                    SaladMeat1,
                    SaladMeat2,
                    SaladMeat3,
                    SaladMeat4
                )
            }

            class Vegetables {
                object Line : Eat("lineSubcategory", R.drawable.line, "Овощные", null)
                object SaladVeg1 : Eat("salad_veg1", R.drawable.salads_veg1, "Salad_veg1", 700)
                object SaladVeg2 : Eat("salad_veg2", R.drawable.salads_veg2, "Salad_veg2", 700)
                object SaladVeg3 : Eat("salad_veg3", R.drawable.salads_veg3, "Salad_veg3", 700)
                object SaladVeg4 : Eat("salad_veg4", R.drawable.salads_veg4, "Salad_veg4", 700)

                var item = mutableListOf(
                    Line,
                    SaladVeg1,
                    SaladVeg2,
                    SaladVeg3,
                    SaladVeg4
                )
            }

            var salads = mutableListOf<Eat>(Line).plus(Fish().item.plus(Meat().item.plus(Vegetables().item)))
        }

        class HotSnacks {
            object Line : Eat("lineCategory", R.drawable.line, "Горячие закуски", null)

            class Fish {
                object Line : Eat("lineSubcategory", R.drawable.line, "Рыбные", null)
                object HotFishSnack2 :
                    Eat("hot_fish_snack2", R.drawable.hot_fish_snack2, "Hot_fish_snack2", 700)

                object HotFishSnack3 :
                    Eat("hot_fish_snack3", R.drawable.hot_fish_snack3, "Hot_fish_snack3", 700)

                object HotFishSnack4 :
                    Eat("hot_fish_snack4", R.drawable.hot_fish_snack4, "Hot_fish_snack3", 700)

                var item = mutableListOf(
                    Line,
                    HotFishSnack2,
                    HotFishSnack3,
                    HotFishSnack4
                )
            }

            class Meat {
                object Line : Eat("lineSubcategory", R.drawable.line, "Мясные", null)
                object HotMeatSnack1 :
                    Eat("hot_meat_snack1", R.drawable.hot_meat_snack1, "Hot_meat_snack1", 700)

                object HotMeatSnack2 :
                    Eat("hot_meat_snack1", R.drawable.hot_meat_snack2, "Hot_meat_snack1", 700)

                var item = mutableListOf(
                    Line,
                    HotMeatSnack1,
                    HotMeatSnack2
                )
            }

            var hotSnacks = mutableListOf<Eat>(Line).plus(Fish().item.plus(Meat().item))
        }

        class First {
            object Line : Eat("lineCategory", R.drawable.line, "Первые блюда", null)

            class Broth {
                object Line : Eat("lineSubcategory", R.drawable.line, "Бульоны", null)
                object Broth1 : Eat("broth1", R.drawable.first_broth1, "Broth1", 700)
                object Broth2 : Eat("broth2", R.drawable.first_broth2, "Broth2", 700)
                object Broth3 : Eat("broth3", R.drawable.first_broth3, "Broth3", 700)

                var item = mutableListOf(
                    Line,
                    Broth1,
                    Broth2,
                    Broth3
                )
            }

            class Filling {
                object Line : Eat("lineSubcategory", R.drawable.line, "Заправочные супы", null)
                object Filling1 : Eat("filling1", R.drawable.first_filling1, "Filling1", 700)
                object Filling2 : Eat("filling2", R.drawable.first_filling2, "Filling2", 700)
                object Filling3 : Eat("filling3", R.drawable.first_filling3, "Filling3", 700)
                object Filling4 : Eat("filling4", R.drawable.first_filling4, "Filling4", 700)

                var item = mutableListOf(
                    Line,
                    Filling1,
                    Filling2,
                    Filling3,
                    Filling4
                )
            }

            class Puree {
                object Line : Eat("lineSubcategory", R.drawable.line, "Пюреобразные супы", null)
                object Puree1 : Eat("puree1", R.drawable.first_puree1, "Puree1", 700)
                object Puree2 : Eat("puree2", R.drawable.first_puree2, "Puree2", 700)
                object Puree3 : Eat("puree3", R.drawable.first_puree3, "Puree3", 700)
                object Puree4 : Eat("puree4", R.drawable.first_puree4, "Puree4", 700)

                var item = mutableListOf(
                    Line,
                    Puree1,
                    Puree2,
                    Puree3,
                    Puree4
                )
            }

            var first = mutableListOf<Eat>(Line).plus(Broth().item.plus(Filling().item.plus(Puree().item)))
        }

        class Second {
            object Line : Eat("lineCategory", R.drawable.line, "Вторые блюда", null)
            class Fish {
                object Line : Eat("lineSubcategory", R.drawable.line, "Рыбные", null)
                object SecondFish1 :
                    Eat("second_fish1", R.drawable.second_fish1, "Second_fish1", 700)

                object SecondFish2 :
                    Eat("second_fish2", R.drawable.second_fish2, "Second_fish2", 700)

                object SecondFish3 :
                    Eat("second_fish3", R.drawable.second_fish3, "Second_fish3", 700)

                object SecondFish4 :
                    Eat("second_fish4", R.drawable.second_fish4, "Second_fish4", 700)

                var item = mutableListOf(
                    Line,
                    SecondFish1,
                    SecondFish2,
                    SecondFish3,
                    SecondFish4
                )
            }

            class Meat {
                object Line : Eat("lineSubcategory", R.drawable.line, "Мясные", null)
                object SecondMeat1 :
                    Eat("second_meat1", R.drawable.second_meat1, "Second_meat1", 700)

                object SecondMeat2 :
                    Eat("second_meat2", R.drawable.second_meat2, "Second_meat2", 700)

                object SecondMeat3 :
                    Eat("second_meat3", R.drawable.second_meat3, "Second_meat3", 700)

                var item = mutableListOf(
                    Line,
                    SecondMeat1,
                    SecondMeat2,
                    SecondMeat3
                )
            }

            class Vegetables {
                object Line : Eat("lineSubcategory", R.drawable.line, "Овощные", null)
                object SecondVeg1 : Eat("second_veg1", R.drawable.second_veg1, "Second_veg1", 700)
                object SecondVeg2 : Eat("second_veg2", R.drawable.second_veg2, "Second_veg2", 700)
                object SecondVeg3 : Eat("second_veg3", R.drawable.second_veg3, "Second_veg3", 700)
                object SecondVeg4 : Eat("second_veg4", R.drawable.second_veg4, "Second_veg4", 700)
                object SecondVeg5 : Eat("second_veg5", R.drawable.second_veg5, "Second_veg5", 700)

                var item = mutableListOf(
                    Line,
                    SecondVeg1,
                    SecondVeg2,
                    SecondVeg3,
                    SecondVeg4,
                    SecondVeg5
                )
            }

            var second = mutableListOf<Eat>(Line).plus(Fish().item.plus(Meat().item.plus(Vegetables().item)))
        }

        class Garnish {
            object Line : Eat("lineCategory", R.drawable.line, "Гарниры", null)
            object Garnish1 : Eat("garnish1", R.drawable.garnish1, "Garnish1", 700)
            object Garnish3 : Eat("garnish3", R.drawable.garnish3, "Garnish3", 700)
            object Garnish4 : Eat("garnish4", R.drawable.garnish4, "Garnish4", 700)

            var item = mutableListOf(
                Line,
                Garnish1,
                Garnish3,
                Garnish4
            )
        }

        class Desserts {
            object Line : Eat("lineCategory", R.drawable.line, "Десерты", null)
            object Desserts1 : Eat("desserts1", R.drawable.desserts1, "Desserts1", 700)
            object Desserts2 : Eat("desserts2", R.drawable.desserts2, "Desserts2", 700)
            object Desserts3 : Eat("desserts3", R.drawable.desserts3, "Desserts3", 700)
            object Desserts4 : Eat("desserts4", R.drawable.desserts4, "Desserts4", 700)
            object Desserts5 : Eat("desserts5", R.drawable.desserts5, "Desserts5", 700)

            var item = mutableListOf(
                Line,
                Desserts1,
                Desserts2,
                Desserts3,
                Desserts4,
                Desserts5
            )
        }

        class Drinks {
            object Line : Eat("lineCategory", R.drawable.line, "Напитки", null)
            class Cold {
                object Line : Eat("lineSubcategory", R.drawable.line, "Холодные", null)
                object DrinksCold1 :
                    Eat("drinks_cold1", R.drawable.drinks_cold1, "drinks_cold1", 700)

                object DrinksCold2 :
                    Eat("drinks_cold2", R.drawable.drinks_cold2, "drinks_cold2", 700)

                object DrinksCold3 :
                    Eat("drinks_cold3", R.drawable.drinks_cold3, "drinks_cold3", 700)

                object DrinksCold4 :
                    Eat("drinks_cold4", R.drawable.drinks_cold4, "drinks_cold4", 700)

                var item = mutableListOf(
                    Line,
                    DrinksCold1,
                    DrinksCold2,
                    DrinksCold3,
                    DrinksCold4
                )
            }

            class Hot {
                object Line : Eat("lineSubcategory", R.drawable.line, "Горячие", null)
                object DrinksHot1 : Eat("drinks_hot1", R.drawable.drinks_hot1, "drinks_hot1", 700)
                object DrinksHot2 : Eat("drinks_hot2", R.drawable.drinks_hot2, "drinks_hot2", 700)
                object DrinksHot3 : Eat("drinks_hot3", R.drawable.drinks_hot3, "drinks_hot3", 700)
                object DrinksHot4 : Eat("drinks_hot4", R.drawable.drinks_hot4, "drinks_hot4", 700)

                var item = mutableListOf(
                    Line,
                    DrinksHot1,
                    DrinksHot2,
                    DrinksHot3,
                    DrinksHot4
                )
            }

            class Alcohol {
                object Line : Eat("lineSubcategory", R.drawable.line, "Алкогольные", null)
                object DrinksAlc1 : Eat("drinks_alc1", R.drawable.drinks_alc1, "drinks_alc1", 700)
                object DrinksAlc2 : Eat("drinks_alc2", R.drawable.drinks_alc2, "drinks_alc2", 700)
                object DrinksAlc3 : Eat("drinks_alc3", R.drawable.drinks_alc3, "drinks_alc3", 700)
                object DrinksAlc4 : Eat("drinks_alc4", R.drawable.drinks_alc4, "drinks_alc4", 700)

                var item = mutableListOf(
                    Line,
                    DrinksAlc1,
                    DrinksAlc2,
                    DrinksAlc3,
                    DrinksAlc4
                )
            }

            var drinks = mutableListOf<Eat>(Line).plus(Cold().item.plus(Hot().item.plus(Alcohol().item)))
        }

        var food = ColdSnacks().coldSnacks.plus(
            Salads().salads.plus(
                HotSnacks().hotSnacks.plus(
                    First().first.plus(
                        Second().second.plus(
                            Garnish().item.plus(
                                Desserts().item.plus(
                                    Drinks().drinks
                                )
                            )
                        )
                    )
                )
            )
        )
    }


}



