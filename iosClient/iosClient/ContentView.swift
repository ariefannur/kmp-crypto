//
//  ContentView.swift
//  iosClient
//
//  Created by ariefmaffrudin on 24/10/23.
//

import SwiftUI
import shared


struct ContentView: View {
    @StateObject var viewModel = ContentViewModel()
    
    var body: some View {
        NavigationView {
        VStack {
            HStack {
                Image("avatar_1")
                    .resizable()
                    .frame(width: 36, height: 36)
                    .clipShape(Circle())
                Spacer(minLength: 0)
                Button(action: {
                    
                }) {
                    Label("", systemImage:"arrow.triangle.2.circlepath")
                }
            }.padding(12)
                List {
                    VStack(alignment: .center) {
                        HStack {
                            Text("$")
                            Text("1420.00").font(.largeTitle)
                        }
                        Text("Portfolio Value").font(.caption2)
                        Text("+25.00(10%)").font(.caption)
                    }.padding(
                        [.top, .bottom], 24
                    ).listRowSeparator(.hidden)
                    .frame(
                        minWidth: 0,
                        maxWidth: .infinity)
                    
                    ForEach(viewModel.items, id: \.self) { item in
                        NavigationLink(destination:DetailViewCompose(coin: item).navigationBarTitle("")
                                        .navigationBarHidden(true)) {
                            HStack {
                                AsyncImage(url: URL(string: item.imgLogo))
                                    .scaledToFit()
                                    .frame(width: 32, height: 32)
                                    .clipped()
                                    .cornerRadius(16)
                                VStack(alignment: .leading) {
                                    Text(item.name).font(.subheadline)
                                    Text("\(item.symbol) . $\(String(format: "%.2f", item.price))").font(.caption)
                                }
                                Spacer(minLength: 0)
                                VStack(alignment: .leading) {
                                    Text(String(format: "%.2f", item.move24)).font(.subheadline)
                                    Text("%\(String(format: "%.2f", item.percentage))"
                                    ).font(.caption)
                                }
                            }.padding([.bottom, .top], 8)
                            .listRowSeparator(.hidden)
                            
                        }
                    }
                    
                }.listStyle(PlainListStyle())
                
            }.navigationBarHidden(true)
        }
    }
}

struct DetailViewCompose : UIViewControllerRepresentable {
    var coin: Coin
    @Environment(\.dismiss) var dismiss
    
    func makeUIViewController(context: Context) -> UIViewController {
        return Detail_iosKt.DetailCoinViewController(coin: coin, onBack: {
            dismiss()
        })
    }
    
    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
