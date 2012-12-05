package frege.imp.contentProposer;

import frege.imp.parser.*;

import java.util.*;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.imp.services.IContentProposer;
import org.eclipse.imp.editor.ErrorProposal;
import org.eclipse.imp.editor.SourceProposal;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.parser.ISourcePositionLocator;

public class ContentProposer implements IContentProposer {
	/**
	 * Returns an array of content proposals applicable relative to the AST of the given
	 * parse controller at the given position.
	 * 
	 * (The provided ITextViewer is not used in the default implementation provided here
	 * but but is stipulated by the IContentProposer interface for purposes such as accessing
	 * the IDocument for which content proposals are sought.)
	 * 
	 * @param controller	A parse controller from which the AST of the document being edited
	 * 						can be obtained
	 * @param int			The offset for which content proposals are sought
	 * @param viewer		The viewer in which the document represented by the AST in the given
	 * 						parse controller is being displayed (may be null for some implementations)
	 * @return				An array of completion proposals applicable relative to the AST of the given
	 * 						parse controller at the given position
	 */
	public ICompletionProposal[] getContentProposals(IParseController ctlr,
			int offset, ITextViewer viewer) {
		List<ICompletionProposal> result = new ArrayList<ICompletionProposal>();

		if (ctlr.getCurrentAst() != null) {
//			IToken token = getToken(ctlr, offset);
//			String prefix = getPrefix(token, offset);
//			FregeParser parser = (FregeParser) ((SimpleLPGParseController) ctlr)
//					.getParser();
//			ISourcePositionLocator locator = ctlr.getSourcePositionLocator();
//			ASTNode node = (ASTNode) locator.findNode(ctlr.getCurrentAst(),
//					token.getStartOffset(), token.getEndOffset());
//
//			if (node != null) {
//				result = computeProposals(prefix, node, offset, parser);
//			}
			result.add(new SourceProposal("foo", "", offset));
		} else {
			result.add(new ErrorProposal(
					"No proposals available - syntax errors", offset));
		}
		return result.toArray(new ICompletionProposal[result.size()]);
	}

}
