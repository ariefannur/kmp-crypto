import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()
    let getListing = InjectGetListingLatest().listing()

    
	var body: some View {
		Text(greet)
            .onAppear {
                test()
            }
    }
    
    func test() {
        getListing.run(params: "") { flow, err in
            
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

