//
//  ContentViewModel.swift
//  iosClient
//
//  Created by ariefmaffrudin on 26/10/23.
//

import Foundation
import shared

class ContentViewModel: ObservableObject {
    @Published var items: [Coin] = []
    
    func fetchData() async {
        let getData = InjectGetListingLatest().listing()
        
        getData.runNative(params: "") { (result) -> () in
            switch result.state {
            case 1:
                print("loading")
            case 2:
                self.items =  result.result?.compactMap({ $0 as? Coin}) ?? []
            default:
                print("error")

            }
        }
    }
    
    init() {
        Task {
            await fetchData()
        }
    }
}
 
