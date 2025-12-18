//
//  SelectMenu.swift
//  iosApp
//
//  Created by Daan Klarenbeek on 17/12/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Presentation
import SwiftUI

struct SelectMenuView: View {
    var title: String
    var options: [SelectMenuOption<AnyObject>]
    var selected: SelectMenuOption<AnyObject>
    var onSelect: (SelectMenuOption<AnyObject>) -> Void

    var contentColor: Color
    var backgroundColor: Color

    @State private var selectedItem: SelectMenuOption<AnyObject>

    init(
        title: String,
        colors: SelectMenuColors,
        options: [SelectMenuOption<AnyObject>],
        selected: SelectMenuOption<AnyObject>,
        onSelect: @escaping (SelectMenuOption<AnyObject>) -> Void,
    ) {
        self.options = options
        self.selected = selected
        self.onSelect = onSelect
        self.title = title

        let contentColor = Color(uiColor: colors.contentColor)
        self.contentColor = contentColor

        let backgroundColor = Color(uiColor: colors.backgroundColor)
        self.backgroundColor = backgroundColor

        _selectedItem = State(initialValue: selected)
    }

    var body: some View {
        HStack {
            Text(title)
                .bold()
                .foregroundStyle(contentColor)
            Spacer()

            Menu {
                Picker("Options", selection: $selectedItem) {
                    ForEach(options, id: \.name) { option in
                        Text(option.name)
                            .tag(option)
                    }
                }
                .onChange(of: selectedItem) {
                    onSelect($0)
                }
            } label: {
                Label(selectedItem.name, systemImage: "chevron.up.chevron.down")
                    .foregroundStyle(contentColor)
                    .frame(maxWidth: .infinity, alignment: .trailing)
            }
        }
        .padding(.horizontal, 16)
        .padding(.vertical, 12)
        .frame(maxWidth: .infinity, alignment: .leading)
        .background(backgroundColor)
        .clipShape(RoundedRectangle(cornerRadius: 8))
    }
}
