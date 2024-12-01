use restaurant;

fn main() {
    restaurant::back_of_house::take_care_trash();
    restaurant::front_of_house::hosting::add_to_waitlist();
    restaurant::front_of_house::hosting::seat_at_table();
    restaurant::front_of_house::serving::take_order();
    restaurant::front_of_house::serving::serve_order();
    restaurant::front_of_house::serving::take_payment();
}
