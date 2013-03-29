/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.flow.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart;
import org.obeonetwork.dsl.cinematic.flow.parts.FlowViewsRepository;
import org.obeonetwork.dsl.cinematic.flow.providers.FlowMessages;

// End of user code

/**
 * 
 * 
 */
public class FlowPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, FlowPropertiesEditionPart {

	protected Text name;
	protected Text description;
	protected ReferencesTable events;
	protected List<ViewerFilter> eventsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> eventsFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable states;
	protected List<ViewerFilter> statesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> statesFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable transitions;
	protected List<ViewerFilter> transitionsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> transitionsFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public FlowPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence flow_Step = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = flow_Step.addStep(FlowViewsRepository.Flow_.Properties.class);
		propertiesStep.addStep(FlowViewsRepository.Flow_.Properties.name);
		propertiesStep.addStep(FlowViewsRepository.Flow_.Properties.description);
		propertiesStep.addStep(FlowViewsRepository.Flow_.Properties.events);
		propertiesStep.addStep(FlowViewsRepository.Flow_.Properties.states);
		propertiesStep.addStep(FlowViewsRepository.Flow_.Properties.transitions);
		
		
		composer = new PartComposer(flow_Step) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == FlowViewsRepository.Flow_.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == FlowViewsRepository.Flow_.Properties.name) {
					return createNameText(parent);
				}
				if (key == FlowViewsRepository.Flow_.Properties.description) {
					return createDescriptionText(parent);
				}
				if (key == FlowViewsRepository.Flow_.Properties.events) {
					return createEventsAdvancedTableComposition(parent);
				}
				if (key == FlowViewsRepository.Flow_.Properties.states) {
					return createStatesAdvancedTableComposition(parent);
				}
				if (key == FlowViewsRepository.Flow_.Properties.transitions) {
					return createTransitionsAdvancedTableComposition(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(FlowMessages.FlowPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, FlowViewsRepository.Flow_.Properties.name, FlowMessages.FlowPropertiesEditionPart_NameLabel);
		name = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, FlowViewsRepository.Flow_.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(FlowViewsRepository.Flow_.Properties.name, FlowViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		createDescription(parent, FlowViewsRepository.Flow_.Properties.description, FlowMessages.FlowPropertiesEditionPart_DescriptionLabel);
		description = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		description.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, FlowViewsRepository.Flow_.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(FlowViewsRepository.Flow_.Properties.description, FlowViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createEventsAdvancedTableComposition(Composite parent) {
		this.events = new ReferencesTable(getDescription(FlowViewsRepository.Flow_.Properties.events, FlowMessages.FlowPropertiesEditionPart_EventsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.events, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				events.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.events, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				events.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.events, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				events.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.events, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				events.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.eventsFilters) {
			this.events.addFilter(filter);
		}
		this.events.setHelpText(propertiesEditionComponent.getHelpContent(FlowViewsRepository.Flow_.Properties.events, FlowViewsRepository.SWT_KIND));
		this.events.createControls(parent);
		this.events.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.events, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData eventsData = new GridData(GridData.FILL_HORIZONTAL);
		eventsData.horizontalSpan = 3;
		this.events.setLayoutData(eventsData);
		this.events.setLowerBound(0);
		this.events.setUpperBound(-1);
		events.setID(FlowViewsRepository.Flow_.Properties.events);
		events.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createEventsAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createStatesAdvancedTableComposition(Composite parent) {
		this.states = new ReferencesTable(getDescription(FlowViewsRepository.Flow_.Properties.states, FlowMessages.FlowPropertiesEditionPart_StatesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.states, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				states.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.states, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				states.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.states, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				states.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.states, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				states.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.statesFilters) {
			this.states.addFilter(filter);
		}
		this.states.setHelpText(propertiesEditionComponent.getHelpContent(FlowViewsRepository.Flow_.Properties.states, FlowViewsRepository.SWT_KIND));
		this.states.createControls(parent);
		this.states.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.states, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData statesData = new GridData(GridData.FILL_HORIZONTAL);
		statesData.horizontalSpan = 3;
		this.states.setLayoutData(statesData);
		this.states.setLowerBound(0);
		this.states.setUpperBound(-1);
		states.setID(FlowViewsRepository.Flow_.Properties.states);
		states.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createStatesAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createTransitionsAdvancedTableComposition(Composite parent) {
		this.transitions = new ReferencesTable(getDescription(FlowViewsRepository.Flow_.Properties.transitions, FlowMessages.FlowPropertiesEditionPart_TransitionsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.transitions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				transitions.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.transitions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				transitions.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.transitions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				transitions.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.transitions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				transitions.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.transitionsFilters) {
			this.transitions.addFilter(filter);
		}
		this.transitions.setHelpText(propertiesEditionComponent.getHelpContent(FlowViewsRepository.Flow_.Properties.transitions, FlowViewsRepository.SWT_KIND));
		this.transitions.createControls(parent);
		this.transitions.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(FlowPropertiesEditionPartImpl.this, FlowViewsRepository.Flow_.Properties.transitions, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData transitionsData = new GridData(GridData.FILL_HORIZONTAL);
		transitionsData.horizontalSpan = 3;
		this.transitions.setLayoutData(transitionsData);
		this.transitions.setLowerBound(0);
		this.transitions.setUpperBound(-1);
		transitions.setID(FlowViewsRepository.Flow_.Properties.transitions);
		transitions.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createTransitionsAdvancedTableComposition

		// End of user code
		return parent;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(FlowViewsRepository.Flow_.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(FlowMessages.Flow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(FlowViewsRepository.Flow_.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(FlowMessages.Flow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#initEvents(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initEvents(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		events.setContentProvider(contentProvider);
		events.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(FlowViewsRepository.Flow_.Properties.events);
		if (eefElementEditorReadOnlyState && events.isEnabled()) {
			events.setEnabled(false);
			events.setToolTipText(FlowMessages.Flow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !events.isEnabled()) {
			events.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#updateEvents()
	 * 
	 */
	public void updateEvents() {
	events.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#addFilterEvents(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEvents(ViewerFilter filter) {
		eventsFilters.add(filter);
		if (this.events != null) {
			this.events.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#addBusinessFilterEvents(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEvents(ViewerFilter filter) {
		eventsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#isContainedInEventsTable(EObject element)
	 * 
	 */
	public boolean isContainedInEventsTable(EObject element) {
		return ((ReferencesTableSettings)events.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#initStates(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initStates(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		states.setContentProvider(contentProvider);
		states.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(FlowViewsRepository.Flow_.Properties.states);
		if (eefElementEditorReadOnlyState && states.isEnabled()) {
			states.setEnabled(false);
			states.setToolTipText(FlowMessages.Flow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !states.isEnabled()) {
			states.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#updateStates()
	 * 
	 */
	public void updateStates() {
	states.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#addFilterStates(ViewerFilter filter)
	 * 
	 */
	public void addFilterToStates(ViewerFilter filter) {
		statesFilters.add(filter);
		if (this.states != null) {
			this.states.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#addBusinessFilterStates(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToStates(ViewerFilter filter) {
		statesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#isContainedInStatesTable(EObject element)
	 * 
	 */
	public boolean isContainedInStatesTable(EObject element) {
		return ((ReferencesTableSettings)states.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#initTransitions(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTransitions(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		transitions.setContentProvider(contentProvider);
		transitions.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(FlowViewsRepository.Flow_.Properties.transitions);
		if (eefElementEditorReadOnlyState && transitions.isEnabled()) {
			transitions.setEnabled(false);
			transitions.setToolTipText(FlowMessages.Flow_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !transitions.isEnabled()) {
			transitions.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#updateTransitions()
	 * 
	 */
	public void updateTransitions() {
	transitions.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#addFilterTransitions(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTransitions(ViewerFilter filter) {
		transitionsFilters.add(filter);
		if (this.transitions != null) {
			this.transitions.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#addBusinessFilterTransitions(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTransitions(ViewerFilter filter) {
		transitionsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.cinematic.flow.parts.FlowPropertiesEditionPart#isContainedInTransitionsTable(EObject element)
	 * 
	 */
	public boolean isContainedInTransitionsTable(EObject element) {
		return ((ReferencesTableSettings)transitions.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return FlowMessages.Flow_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
